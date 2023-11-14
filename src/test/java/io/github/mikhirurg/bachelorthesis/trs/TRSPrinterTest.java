package io.github.mikhirurg.bachelorthesis.trs;

import io.github.mikhirurg.bachelorthesis.ProgramBuilder;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

class TRSPrinterTest {

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