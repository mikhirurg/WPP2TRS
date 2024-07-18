package io.github.mikhirurg.bachelorthesis.interpreter;

import charlie.reader.CoraInputReader;
import charlie.terms.Term;
import charlie.terms.position.Position;
import charlie.trs.TRS;
import charlie.trs.TrsFactory;
import cora.io.DefaultOutputModule;
import cora.io.OutputModule;
import cora.io.ProofObject;
import cora.reduction.Reducer;
import cora.termination.TerminationHandler;
import io.github.mikhirurg.bachelorthesis.ProgramBuilder;
import io.github.mikhirurg.bachelorthesis.interpreter.exception.WhileCoraInterpreterTypeException;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * WhileCoraInterpreter is a class for the WPP2TRS console application.
 * Currently, it supports:
 * <ul>
 *     <li> While++ program translation into the LCTRS,
 *     <li> Executing the translated LCTRS using the cora rewriting engine,
 *     <li> Proving the program termination using the cora constrained rewriting analyser
 * </ul>
 *
 */
public class WhileCoraInterpreter {

    /**
     * The object that represents the current element that was read from the input stream
     */
    private Object input;

    /**
     * The buffered reader that represents the standard input for the interpreter
     */
    private final BufferedReader reader;

    /**
     * The buffered writer that represents the standard output of the interpreter
     */
    private final BufferedWriter writer;

    /**
     * The current token used in the stream tokenizer.
     */
    private final StreamTokenizer tok;

    /**
     * WhileCoraInterpreter constructor.
     * @param inputStream the input stream for the interpreter
     * @param outputStream the output stream for the interpreter
     */
    public WhileCoraInterpreter(InputStream inputStream, OutputStream outputStream) {
        this.input = null;
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        this.tok = new StreamTokenizer(reader);
    }

    /**
     * The method attempts to read the integer value from the standard input stream.
     * @throws IOException if there is a problem with the input stream
     * @throws WhileCoraInterpreterTypeException if there is a non-integer value in the input stream
     */
    public void readInt() throws IOException {
        if (tok.nextToken() == StreamTokenizer.TT_NUMBER) {
            input = (int) tok.nval;
        } else {
            throw new WhileCoraInterpreterTypeException(WhileType.INT, WhileType.STRING);
        }
    }

    /**
     * The method attempts to read the string value from the standard input stream.
     * @throws IOException if there is a problem with the input stream
     */
    public void readString() throws IOException {
        tok.nextToken();
        input = tok.sval;
    }

    /**
     * The method attempts to read the boolean value form the standard input stream.
     * @throws IOException if there is a problem with the input stream
     * @throws WhileCoraInterpreterTypeException if there is a non-boolean value in the input stream
     */
    public void readBool() throws IOException {
        if (tok.nextToken() == StreamTokenizer.TT_WORD) {
            if ("true".equals(tok.sval)) {
                input = true;
            } else if ("false".equals(tok.sval)) {
                input = false;
            } else {
                throw new WhileCoraInterpreterTypeException(WhileType.BOOL, WhileType.STRING);
            }
        }
    }

    /**
     * The method attempts to write the integer value to the standard output stream
     * @param intVal the value that is written to the output stream
     * @throws IOException if there is a problem with the output stream
     */
    public void writeInt(int intVal) throws IOException {
        writer.write(String.valueOf(intVal));
        writer.flush();
    }

    /**
     * The method attempts to write the boolean value to the standard output stream
     * @param boolVal the value that is written to the output stream
     * @throws IOException if there is a problem with the output stream
     */
    public void writeBool(boolean boolVal) throws IOException {
        writer.write(String.valueOf(boolVal));
        writer.flush();
    }

    /**
     * The method attempts to write the string value to the standard output stream
     * @param strVal the string value that is written to the output stream
     * @throws IOException if there is a problem with the output stream
     */
    public void writeString(String strVal) throws IOException {
        writer.write(String.valueOf(strVal));
        writer.flush();
    }

    /**
     * The method that creates the cora representation of the LCTRS from the string
     * @param trsString the input string representing the LCTRS
     * @return the cora class representation of the LCTRS
     */
    private static TRS fromString(String trsString) {
        return CoraInputReader.readTrsFromString(trsString, TrsFactory.LCTRS);
    }

    /**
     * The method checks what type of element are we trying to read from the standard input
     * @param input the LCTRS term representing the operation on the input stream
     * @return the letter representing the type of the element we're trying to read ("I" - integer, "B" - boolean, "S" - string)
     */
    private static String testInput(String input) {
        return switch (input) {
            case "tailI(nil)" -> "I";
            case "tailB(nil)" -> "B";
            case "tailS(nil)" -> "S";
            default -> null;
        };
    }

    /**
     * The method checks what type of the element are we trying to write to the standard output
     * @param output the LCTRS term representing the operation on the output stream
     * @return the letter representing the type of the element we're trying to write ("I" - integer, "B" - boolean, "S" - string)
     */
    private static String testOutput(String output) {
        if (output.matches("consI.*")) {
            return "I";
        } else if (output.matches("consB.*")) {
            return "B";
        } else if (output.matches("consS.*")) {
            return "S";
        }
        return null;
    }

    /**
     * The method performs the reduction of the given term to the normal form using the reducer
     * @param term the term we're reducing to the normal form
     * @param reducer the reducer that is used to reduce the term to the normal form
     * @return the normal form to which the term <code>term</code> was reduced using the reducer <code>reducer</code>
     */
    private static Term reduceTermToFinalForm(Term term, Reducer reducer) {
        Term oldTerm;
        do {
            oldTerm = term;
            term = reducer.leftmostInnermostReduce(term);
        } while (term != null);

        return oldTerm;
    }

    /**
     * The method finds the position of the <code>argNum</code>-th argument in the term <code>term</code>.
     * @param term the term where we try to find the position of the argument
     * @param argNum the order of the argument in the term for which we want to find the position
     * @return the position of the argument in the LCTRS term
     */
    private static Position findArgumentPos(Term term, int argNum) {
        return term.queryPositions(false)
                .stream()
                .filter(e -> (STR."\{argNum}.ε").equals(e.toString()))
                .findAny().orElse(null);
    }

    /**
     * The main method of the WPP2TRS application.
     * Takes the path to the While++ program as the first argument.
     * Additional parameters description:
     * <ul>
     *     <li> "--printlctrs" - prints the LCTRS generated for the input While++ program,
     *     <li> "--exec" - executes the LCTRS generated for the input While++ program,
     *     <li> "--explicit" - shows every reduction step in the LCTRS,
     *     <li> "--provetermination" - attempts to prove the termination of the input While++ program
     * </ul>
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("You need to specify an input While++ code file!");
            return;
        }

        List<String> argsList = Arrays.stream(args).toList();

        boolean isExplicit = false;
        boolean isPrintLCTRS = false;
        boolean isProveTermination = false;
        boolean isExec = false;
        if (args.length > 1) {
            isPrintLCTRS = argsList.contains("--printlctrs");
            isExplicit = argsList.contains("--explicit");
            isProveTermination = argsList.contains("--provetermination");
            isExec = argsList.contains("--exec");
        }

        WhileCoraInterpreter interpreter = new WhileCoraInterpreter(System.in, System.out);

        try {
            WhileStatement program = ProgramBuilder.parseProgram(new File(args[0]));

            TRSPrinter printer = new TRSPrinter();

            program.acceptTRSPrinter(printer);

            if (isPrintLCTRS) {
                interpreter.writeString(STR."\{printer.getRulesRepresentation()}\n");
            }

            TRS trs = fromString(printer.getRulesRepresentation());

            if (isProveTermination) {
                ProofObject proofObject = TerminationHandler.proveTermination(trs);
                OutputModule outputModule = DefaultOutputModule.createDefaultModule();
                proofObject.justify(outputModule);
                interpreter.writeString(STR."Termination answer: \{proofObject.queryAnswer().name()}\n");
                interpreter.writeString(STR."\{outputModule}\n");
            }

            if (isExec) {

                String startingTerm = "stm_1(nil, nil)";

                Term term = CoraInputReader.readTerm(startingTerm, trs);

                Reducer reducer = new Reducer(trs);

                do {
                    term = reducer.leftmostInnermostReduce(term);
                    if (term != null) {

                        if (isExplicit) {
                            interpreter.writeString(STR."⇒ \{term}\n");
                        }

                        if (term.numberArguments() > 0) {
                            String inputType = testInput(term.queryArgument(1).toString());
                            if (inputType != null) {
                                switch (inputType) {
                                    case "I" -> interpreter.readInt();
                                    case "B" -> interpreter.readBool();
                                    case "S" -> interpreter.readString();
                                }

                                term = term.replaceSubterm(term.queryPositions(false).get(1),
                                        CoraInputReader.readTerm("tail" + inputType + "(cons" + inputType + "(" + interpreter.input + ", nil))", trs));

                                for (Position position : term.queryPositions(false)) {
                                    if (term.querySubterm(position).toString().equals("head" + inputType + "(nil)")) {
                                        String value = interpreter.input.toString();
                                        if (inputType.equals("S")) {
                                            value = "\"" + value + "\"";
                                        }
                                        term = term.replaceSubterm(position,
                                                CoraInputReader.readTerm("head" + inputType + "(cons" + inputType + "(" + value + ", nil))", trs));
                                        break;
                                    }
                                }
                            }

                            Position outputListPos = findArgumentPos(term, 2);
                            Term outputListTerm = term.querySubterm(outputListPos);
                            String outputType = testOutput(outputListTerm.toString());
                            if (outputType != null) {
                                Term reducedOutputTerm = reduceTermToFinalForm(outputListTerm, reducer);
                                String valToPrint = reducedOutputTerm.toString().substring(6, reducedOutputTerm.toString()
                                        .lastIndexOf(", nil"));
                                switch (outputType) {
                                    case "I" -> interpreter.writeInt(Integer.parseInt(valToPrint));
                                    case "B" -> interpreter.writeBool(Boolean.parseBoolean(valToPrint));
                                    case "S" -> interpreter.writeString(valToPrint.substring(1, valToPrint.length() - 1)
                                            .replaceAll("\\\\n", "\n")
                                            .replaceAll("\\\\\"", "\"")
                                            .replaceAll("\\\\", "\\")
                                    );
                                }

                                term = term.replaceSubterm(outputListPos, CoraInputReader.readTerm("nil", trs));
                            }
                        }
                    }
                } while (term != null);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
