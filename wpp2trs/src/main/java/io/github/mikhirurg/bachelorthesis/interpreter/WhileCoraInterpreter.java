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
import cora.termination.TerminationAnswer;
import cora.termination.TerminationHandler;
import io.github.mikhirurg.bachelorthesis.ProgramBuilder;
import io.github.mikhirurg.bachelorthesis.interpreter.exception.WhileCoraInterpreterTypeException;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class WhileCoraInterpreter {

    private Object input;

    private final BufferedReader reader;

    private final BufferedWriter writer;

    private final StreamTokenizer tok;

    public WhileCoraInterpreter(InputStream inputStream, OutputStream outputStream) {
        this.input = null;
        this.reader = new BufferedReader(new InputStreamReader(inputStream));
        this.writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        this.tok = new StreamTokenizer(reader);
    }

    public void readInt() throws IOException {
        if (tok.nextToken() == StreamTokenizer.TT_NUMBER) {
            input = (int) tok.nval;
        } else {
            throw new WhileCoraInterpreterTypeException(WhileType.INT, WhileType.STRING);
        }
    }

    public void readString() throws IOException {
        tok.nextToken();
        input = tok.sval;
    }


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

    public void writeInt(int intVal) throws IOException {
        writer.write(String.valueOf(intVal));
        writer.flush();
    }

    public void writeBool(boolean boolVal) throws IOException {
        writer.write(String.valueOf(boolVal));
        writer.flush();
    }

    public void writeString(String strVal) throws IOException {
        writer.write(String.valueOf(strVal));
        writer.flush();
    }

    private static TRS fromString(String trsString) {
        return CoraInputReader.readTrsFromString(trsString, TrsFactory.LCTRS);
    }

    private static String testInput(String input) {
        return switch (input) {
            case "tailI(nil)" -> "I";
            case "tailB(nil)" -> "B";
            case "tailS(nil)" -> "S";
            default -> null;
        };
    }

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

    private static Term reduceTermToFinalForm(Term term, Reducer reducer) {
        Term oldTerm;
        do {
            oldTerm = term;
            term = reducer.leftmostInnermostReduce(term);
        } while (term != null);

        return oldTerm;
    }

    private static Position findArgumentPos(Term term, int argNum) {
        return term.queryPositions(false)
                .stream()
                .filter(e -> (STR."\{argNum}.ε").equals(e.toString()))
                .findAny().orElse(null);
    }

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
                interpreter.writeString(STR."Termination answer: \{((TerminationAnswer) proofObject.queryAnswer()).name()}\n");
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
