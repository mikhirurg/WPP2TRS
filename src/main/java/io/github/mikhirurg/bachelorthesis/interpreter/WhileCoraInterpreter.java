package io.github.mikhirurg.bachelorthesis.interpreter;

import cora.reader.CoraInputReader;
import cora.rewriting.TRS;
import cora.terms.Term;
import cora.terms.position.Position;
import io.github.mikhirurg.bachelorthesis.ProgramBuilder;
import io.github.mikhirurg.bachelorthesis.interpreter.exception.WhileCoraInterpreterTypeException;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

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

    private static String getExtension(String filename) {
        int i = filename.lastIndexOf('.');
        if (i >= 0) return filename.substring(i+1);
        return "";
    }

    private static TRS fromString(String trsString) {
        return CoraInputReader.readTrsFromString(trsString);
    }

    private static String testInput(String input) {
        return switch (input) {
            case "moveI(nil)" -> "I";
            case "moveB(nil)" -> "B";
            case "moveS(nil)" -> "S";
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

    public static void main(String[] args) throws IOException {

        if (args.length == 0) {
            System.out.println("You need to specify an input While++ code file!");
            return;
        }

        boolean isExplicit = false;
        if (args.length == 2) {
            isExplicit = ("--explicit".equals(args[1]));
        }

        WhileCoraInterpreter interpreter = new WhileCoraInterpreter(System.in, System.out);

        WhileStatement program = ProgramBuilder.parseProgram(new File(args[0]));

        TRSPrinter printer = new TRSPrinter();

        program.acceptTRSPrinter(printer);

        TRS trs = fromString(printer.getRulesRepresentation());

        String startingTerm = "stm_1(nil, nil)";

        Term term = CoraInputReader.readTerm(startingTerm, trs);

        do {
            term = trs.leftmostInnermostReduce(term);
            if (term != null) {

                if (isExplicit) {
                    System.out.println("⇒ " + term);
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
                                CoraInputReader.readTerm("move" + inputType + "(cons" + inputType + "(" + interpreter.input + ", nil))", trs));

                        for (Position position : term.queryPositions(false)) {
                            if (term.querySubterm(position).toString().equals("take" + inputType + "(nil)")) {
                                String value = interpreter.input.toString();
                                if (inputType.equals("S")) {
                                    value = "\"" + value + "\"";
                                }
                                term = term.replaceSubterm(position,
                                        CoraInputReader.readTerm("take" + inputType + "(cons" + inputType + "(" + value + ", nil))", trs));
                                break;
                            }
                        }
                    }

                    String outputTermStr = term.queryArgument(2).toString();
                    String outputType = testOutput(outputTermStr);
                    if (outputType != null) {
                        String valToPrint = term.queryArgument(2).toString().substring(6, outputTermStr.lastIndexOf( ", nil"));
                        switch (outputType) {
                            case "I" -> {
                                interpreter.writeInt(Integer.parseInt(valToPrint));
                            }
                            case "B" -> {
                                interpreter.writeBool(Boolean.parseBoolean(valToPrint));
                            }
                            case "S" -> {
                                interpreter.writeString(valToPrint.substring(1, valToPrint.length() - 1)
                                        .replaceAll("\\\\n", "\n"));
                            }
                        }

                        term = term.replaceSubterm(term.queryPositions(false).get(3), CoraInputReader.readTerm("nil", trs));
                    }
                }
            }
        } while (term != null);
    }
}
