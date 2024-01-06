package io.github.mikhirurg.bachelorthesis.trs;

import io.github.mikhirurg.bachelorthesis.ProgramBuilder;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;

class TRSPrinterTest {

    private final static String LIST_RULES =
            """
                    nil :: list
                    consI :: Int -> list -> list
                    consB :: Bool -> list -> list
                    consS :: String -> list -> list
                                
                    appendI :: Int -> list -> list
                    appendB :: Bool -> list -> list
                    appendS :: String -> list -> list
                                
                    takeI :: list -> Int
                    takeB :: list -> Bool
                    takeS :: list -> String
                                
                    moveI :: list -> list
                    moveB :: list -> list
                    moveS :: list -> list

                    appendI(i, l) -> consI(i, l)
                    appendB(b, l) -> consB(b, l)
                    appendS(str, l) -> consS(str, l)

                    takeI(consI(i, l)) -> i
                    takeB(consB(b, l)) -> b
                    takeS(consS(str, l)) -> str

                    moveI(consI(i, l)) -> l
                    moveB(consB(b, l)) -> l
                    moveS(consS(str, l)) -> l
                                
                    """;

    private void test(File file) throws IOException {
        WhileStatement p1 = ProgramBuilder.parseProgram(file);
        TRSPrinter printer = new TRSPrinter();

        p1.acceptTRSPrinter(printer);

        /*System.out.println(printer.getTRSRules()
                .stream()
                .map(TRSRule::toString)
                .collect(Collectors.joining("\n"))
        );*/

        System.out.println(printer.getRulesRepresentation());

        String outName = "results/" + file.getName().substring(0, file.getName().indexOf(".")) + ".lcstrs";
        File outFile = new File(outName);

        if (outFile.exists() || outFile.createNewFile()) {
            PrintWriter printWriter = new PrintWriter(outName);
            printWriter.println(printer.getRulesRepresentation());
            printWriter.close();
        }
    }

    private void test(String givenProgram, String correctTranslation) {
        WhileStatement p1 = ProgramBuilder.parseProgram(givenProgram);
        TRSPrinter printer = new TRSPrinter();

        p1.acceptTRSPrinter(printer);

        assertEquals(correctTranslation, printer.getRulesRepresentation());
    }

    @Test
    void testSkip() {
        test("skip", LIST_RULES +
                """
                 stm_1 :: list -> list -> list
                 stm_2 :: list -> list -> list
                 
                 stm_1(in, out) -> stm_2(in, out) | true
                 stm_2(in, out) -> out | true""");
    }

    @Test
    void testDeclareInt() {
        test("int x := 0", LIST_RULES +
                """
                stm_1 :: list -> list -> list
                stm_2 :: list -> list -> Int -> list
                
                stm_1(in, out) -> stm_2(in, out, 0) | true
                stm_2(in, out, x) -> out | true""");
    }

    @Test
    void testDeclareBool() {
        test("bool b := true", LIST_RULES +
                """
                stm_1 :: list -> list -> list
                stm_2 :: list -> list -> Bool -> list
                
                stm_1(in, out) -> stm_2(in, out, true) | true
                stm_2(in, out, b) -> out | true""");
    }

    @Test
    void testDeclareString() {
        test("string s := \"str\"", LIST_RULES +
                """
                stm_1 :: list -> list -> list
                stm_2 :: list -> list -> String -> list
                
                stm_1(in, out) -> stm_2(in, out, "str") | true
                stm_2(in, out, s) -> out | true""");
    }

    @Test
    void testPrintInt() {
        test("printInt(1)", LIST_RULES +
                """
                stm_1 :: list -> list -> list
                stm_2 :: list -> list -> list
                
                stm_1(in, out) -> stm_2(in, consI(1, out)) | true
                stm_2(in, out) -> out | true""");
    }

    @Test
    void testPrintBool() {
        test("printBool(true)", LIST_RULES +
                """
                stm_1 :: list -> list -> list
                stm_2 :: list -> list -> list
                
                stm_1(in, out) -> stm_2(in, consB(true, out)) | true
                stm_2(in, out) -> out | true""");
    }

    @Test
    void testPrintString() {
        test("printString(\"test\")", LIST_RULES +
                """
                stm_1 :: list -> list -> list
                stm_2 :: list -> list -> list
                
                stm_1(in, out) -> stm_2(in, consS("test", out)) | true
                stm_2(in, out) -> out | true""");
    }

    @Test
    void testDeclareAndAssignment() {
        test("int x := 0; x := x + 1", LIST_RULES +
                """
                stm_1 :: list -> list -> list
                stm_2 :: list -> list -> Int -> list
                stm_3 :: list -> list -> Int -> list
                stm_4 :: list -> list -> Int -> list
                                
                stm_1(in, out) -> stm_2(in, out, 0) | true
                stm_2(in, out, x) -> stm_3(in, out, x) | true
                stm_3(in, out, x) -> stm_4(in, out, (x + 1)) | true
                stm_4(in, out, x) -> out | true""");
    }

    @Test
    void testIf() {
        test("if true then printString(\"true\") else printString(\"false\")",
                LIST_RULES + """
                        stm_1 :: list -> list -> list
                        stm_2 :: list -> list -> list
                        stm_4 :: list -> list -> list
                        stm_3 :: list -> list -> list
                        stm_5 :: list -> list -> list
                        stm_6 :: list -> list -> list
                                                
                        stm_1(in, out) -> stm_2(in, out) | true
                        stm_2(in, out) -> stm_3(in, consS("true", out)) | true
                        stm_1(in, out) -> stm_4(in, out) | not(true)
                        stm_4(in, out) -> stm_5(in, consS("false", out)) | true
                        stm_3(in, out) -> stm_6(in, out) | true
                        stm_5(in, out) -> stm_6(in, out) | true
                        stm_6(in, out) -> out | true""");
    }

    @Test
    void testWhile() {
        test("while true do printInt(1)", LIST_RULES +
                """
                stm_1 :: list -> list -> list
                stm_2 :: list -> list -> list
                stm_3 :: list -> list -> list
                stm_4 :: list -> list -> list
                                                
                stm_1(in, out) -> stm_2(in, out) | true
                stm_2(in, out) -> stm_3(in, consI(1, out)) | true
                stm_3(in, out) -> stm_1(in, out) | true
                stm_1(in, out) -> stm_4(in, out) | not(true)
                stm_4(in, out) -> out | true""");
    }

    @Test
    void translateAll() throws IOException {
        Files.walk(Path.of("programs/")).forEach(e -> {
            try {
                test(e.toFile());
            } catch (IOException ignored) {

            }
        });
    }

    @org.junit.jupiter.api.Test
    void testProgram1() throws IOException {
        test(new File("programs/p1.wpp"));
    }

    @org.junit.jupiter.api.Test
    void testProgram2() throws IOException {
        test(new File("programs/p2.wpp"));
    }

    @org.junit.jupiter.api.Test
    void testProgram3() throws IOException {
        test(new File("programs/p3.wpp"));
    }

    @Test
    void testProgram4() throws IOException {
        test(new File("programs/p4.wpp"));
    }

    @Test
    void testProgramEuclid() throws IOException {
        test(new File("programs/euclid.wpp"));
    }

    @Test
    void testProgramPow() throws IOException {
        test(new File("programs/pow.wpp"));
    }

    @Test
    void testPrimeTest() throws IOException {
        test(new File("programs/prime_test.wpp"));
    }

    @Test
    void testNearestSquareRoot() throws IOException {
        test(new File("programs/square_root.wpp"));
    }
}