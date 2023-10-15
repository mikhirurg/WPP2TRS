package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileEq;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileFalseConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileNot;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileTrueConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrintInt;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print.WhilePrintString;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileString;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileBoolVar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhileIfTest {

    private final WhileIf WHILE_IF_1 = new WhileIf(
            new WhileTrueConst(),
            new WhilePrintInt(new WhileConst("10")),
            new WhileSkip()
    );

    private final WhileIf WHILE_IF_2 = new WhileIf(
            new WhileTrueConst(),
            new WhileIf(
                    new WhileNot(new WhileFalseConst()),
                    new WhileSkip(),
                    new WhilePrintString(new WhileString("Hello!"))
            ),
            new WhileSkip()
    );

    private final WhileIf WHILE_IF_3 = new WhileIf(
            new WhileEq<>(new WhileConst("10"), new WhileConst("15")),
            new WhileSkip(),
            new WhileAssignment(new WhileBoolVar("b"), new WhileTrueConst())
    );

    @Test
    void getCondition() {
        assertEquals(new WhileTrueConst(), WHILE_IF_1.getCondition());

        assertEquals(new WhileTrueConst(), WHILE_IF_2.getCondition());

        assertEquals(new WhileEq<>(new WhileConst("10"), new WhileConst("15")),
                WHILE_IF_3.getCondition());
    }

    @Test
    void getStatement1() {
        assertEquals(new WhilePrintInt(new WhileConst("10")), WHILE_IF_1.getStatement1());

        assertEquals(new WhileIf(
                new WhileNot(new WhileFalseConst()),
                new WhileSkip(),
                new WhilePrintString(new WhileString("Hello!"))
        ), WHILE_IF_2.getStatement1());

        assertEquals(new WhileSkip(), WHILE_IF_3.getStatement1());
    }

    @Test
    void getStatement2() {
        assertEquals(new WhileSkip(), WHILE_IF_1.getStatement2());

        assertEquals(new WhileSkip(), WHILE_IF_2.getStatement2());

        assertEquals(new WhileAssignment(new WhileBoolVar("b"), new WhileTrueConst()),
                WHILE_IF_3.getStatement2());
    }

    @Test
    void testToString() {
        assertEquals("if true then (printInt(10)) else (skip)", WHILE_IF_1.toString());
        assertEquals("if true then (if not(false) then (skip) else (printString(\"Hello!\"))) else (skip)",
                WHILE_IF_2.toString());
        assertEquals("if (10 = 15) then (skip) else (b := true)", WHILE_IF_3.toString());
    }

    @Test
    void acceptTRSPrinter() {
    }

    @Test
    void testEquals() {
        assertEquals(new WhileIf(
                new WhileTrueConst(),
                new WhilePrintInt(new WhileConst("10")),
                new WhileSkip()
        ), WHILE_IF_1);

        assertEquals(new WhileIf(
                new WhileTrueConst(),
                new WhileIf(
                        new WhileNot(new WhileFalseConst()),
                        new WhileSkip(),
                        new WhilePrintString(new WhileString("Hello!"))
                ),
                new WhileSkip()
        ), WHILE_IF_2);

        assertEquals(new WhileIf(
                new WhileEq<>(new WhileConst("10"), new WhileConst("15")),
                new WhileSkip(),
                new WhileAssignment(new WhileBoolVar("b"), new WhileTrueConst())
        ), WHILE_IF_3);
    }
}