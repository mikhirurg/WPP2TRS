package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhilePlus;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileFalseConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileNot;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileString;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileBoolVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileStringVar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhileAssignmentTest {

    private final WhileAssignment WHILE_ASSIGNMENT_1 = new WhileAssignment(
            new WhileIntVar("x"),
            new WhilePlus(new WhileConst("10"), new WhileIntVar("y"))
    );

    private final WhileAssignment WHILE_ASSIGNMENT_2 = new WhileAssignment(
            new WhileBoolVar("b"),
            new WhileNot(new WhileFalseConst())
    );

    private final WhileAssignment WHILE_ASSIGNMENT_3 = new WhileAssignment(
            new WhileStringVar("str"),
            new WhileString("abc")
    );

    @Test
    void getVariable() {
        assertEquals(new WhileIntVar("x"), WHILE_ASSIGNMENT_1.getVariable());
        assertEquals(new WhileBoolVar("b"), WHILE_ASSIGNMENT_2.getVariable());
        assertEquals(new WhileStringVar("str"), WHILE_ASSIGNMENT_3.getVariable());
    }

    @Test
    void getExpression() {
        assertEquals(new WhilePlus(new WhileConst("10"), new WhileIntVar("y")),
                WHILE_ASSIGNMENT_1.getExpression());

        assertEquals(new WhileNot(new WhileFalseConst()), WHILE_ASSIGNMENT_2.getExpression());

        assertEquals(new WhileString("abc"), WHILE_ASSIGNMENT_3.getExpression());
    }

    @Test
    void testToString() {
        assertEquals("x := (10 + y)", WHILE_ASSIGNMENT_1.toString());
        assertEquals("b := not(false)", WHILE_ASSIGNMENT_2.toString());
        assertEquals("str := \"abc\"", WHILE_ASSIGNMENT_3.toString());
    }

    @Test
    void acceptTRSPrinter() {
    }

    @Test
    void testEquals() {
        assertEquals(new WhileAssignment(
                new WhileIntVar("x"),
                new WhilePlus(new WhileConst("10"), new WhileIntVar("y"))
        ), WHILE_ASSIGNMENT_1);

        assertEquals(new WhileAssignment(
                new WhileBoolVar("b"),
                new WhileNot(new WhileFalseConst())
        ), WHILE_ASSIGNMENT_2);

        assertEquals(new WhileAssignment(
                new WhileStringVar("str"),
                new WhileString("abc")
        ), WHILE_ASSIGNMENT_3);
    }
}