package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhilePlus;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileLeq;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileTrueConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhileWhileTest {

    private final WhileWhile WHILE_WHILE_1 = new WhileWhile(
            new WhileTrueConst(),
            new WhileSkip()
    );

    private final WhileWhile WHILE_WHILE_2 = new WhileWhile(
            new WhileLeq(new WhileIntVar("x"), new WhileConst("10")),
            new WhileAssignment(
                    new WhileIntVar("x"),
                    new WhilePlus(
                            new WhileIntVar("x"),
                            new WhileConst("1")
                    )
            )
    );

    @Test
    void getCondition() {
        assertEquals(new WhileTrueConst(), WHILE_WHILE_1.getCondition());

        assertEquals(new WhileLeq(new WhileIntVar("x"), new WhileConst("10")),
                WHILE_WHILE_2.getCondition());
    }

    @Test
    void getStatement() {
        assertEquals(new WhileSkip(), WHILE_WHILE_1.getStatement());

        assertEquals(new WhileAssignment(
                new WhileIntVar("x"),
                new WhilePlus(
                        new WhileIntVar("x"),
                        new WhileConst("1")
                )
        ), WHILE_WHILE_2.getStatement());
    }

    @Test
    void testToString() {
        assertEquals("while true do (skip)", WHILE_WHILE_1.toString());

        assertEquals("while (x <= 10) do (x := (x + 1))", WHILE_WHILE_2.toString());
    }

    @Test
    void acceptTRSPrinter() {
    }

    @Test
    void testEquals() {
        assertEquals(new WhileWhile(
                new WhileTrueConst(),
                new WhileSkip()
        ), WHILE_WHILE_1);

        assertEquals(new WhileWhile(
                new WhileLeq(new WhileIntVar("x"), new WhileConst("10")),
                new WhileAssignment(
                        new WhileIntVar("x"),
                        new WhilePlus(
                                new WhileIntVar("x"),
                                new WhileConst("1")
                        )
                )
        ), WHILE_WHILE_2);
    }
}