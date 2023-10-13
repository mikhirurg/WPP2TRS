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

class WhileVarDeclarationTest {

    private final WhileVarDeclaration WHILE_DECLARATION_1 = new WhileVarDeclaration(
            new WhileIntVar("x"),
            new WhilePlus(new WhileConst("10"), new WhileIntVar("y"))
    );

    private final WhileVarDeclaration WHILE_DECLARATION_2 = new WhileVarDeclaration(
            new WhileBoolVar("b"),
            new WhileNot(new WhileFalseConst())
    );

    private final WhileVarDeclaration WHILE_DECLARATION_3 = new WhileVarDeclaration(
            new WhileStringVar("str"),
            new WhileString("abc")
    );

    @Test
    void testToString() {
        assertEquals("int x := (10 + y)", WHILE_DECLARATION_1.toString());
        assertEquals("bool b := not(false)", WHILE_DECLARATION_2.toString());
        assertEquals("string str := \"abc\"", WHILE_DECLARATION_3.toString());
    }

    @Test
    void acceptTRSPrinter() {
    }

    @Test
    void getVariable() {
        assertEquals(new WhileIntVar("x"), WHILE_DECLARATION_1.getVariable());
        assertEquals(new WhileBoolVar("b"), WHILE_DECLARATION_2.getVariable());
        assertEquals(new WhileStringVar("str"), WHILE_DECLARATION_3.getVariable());
    }

    @Test
    void getExpression() {
        assertEquals(new WhilePlus(new WhileConst("10"), new WhileIntVar("y")),
                WHILE_DECLARATION_1.getExpression());

        assertEquals(new WhileNot(new WhileFalseConst()), WHILE_DECLARATION_2.getExpression());

        assertEquals(new WhileString("abc"), WHILE_DECLARATION_3.getExpression());
    }

    @Test
    void testEquals() {
        assertEquals(new WhileVarDeclaration(
                new WhileIntVar("x"),
                new WhilePlus(new WhileConst("10"), new WhileIntVar("y"))
        ), WHILE_DECLARATION_1);

        assertEquals(new WhileVarDeclaration(
                new WhileBoolVar("b"),
                new WhileNot(new WhileFalseConst())
        ), WHILE_DECLARATION_2);

        assertEquals(new WhileVarDeclaration(
                new WhileStringVar("str"),
                new WhileString("abc")
        ), WHILE_DECLARATION_3);
    }
}