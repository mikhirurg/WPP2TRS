package io.github.mikhirurg.bachelorthesis;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;
import io.github.mikhirurg.bachelorthesis.trs.TRSRule;

import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        String program = "int x := 1; bool y := false; string z := \"Hello World!\"; if (true = true) then (printString(z); skip; skip) else (y := true)";

        WhileStatement p = ProgramBuilder.parseProgram(program);

        System.out.println(p.toString());

        TRSPrinter printer = new TRSPrinter();

        p.acceptTRSPrinter(printer);

        System.out.println(printer.getTRSRules().stream().map(TRSRule::toString).collect(Collectors.joining("\n")));
    }
}
