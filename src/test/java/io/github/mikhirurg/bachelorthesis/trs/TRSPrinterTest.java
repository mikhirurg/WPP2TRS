package io.github.mikhirurg.bachelorthesis.trs;

import io.github.mikhirurg.bachelorthesis.ProgramBuilder;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;

import java.io.File;
import java.io.IOException;
import java.util.stream.Collectors;

class TRSPrinterTest {

    private void test(File file) throws IOException {
        WhileStatement p1 = ProgramBuilder.parseProgram(file);
        TRSPrinter printer = new TRSPrinter();

        p1.acceptTRSPrinter(printer);

        System.out.println(printer.getTRSRules()
                .stream()
                .map(TRSRule::toString)
                .collect(Collectors.joining("\n"))
        );
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
}