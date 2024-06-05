package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhilePlus;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileString;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileStringExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileBoolVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WhileEqTest {

    private final WhileEq<WhileBooleanExpression> WHILE_EQ_1 = new WhileEq<>(
            new WhileTrueConst(),
            new WhileBoolVar("x")
    );

    private final WhileEq<WhileStringExpression> WHILE_EQ_2 = new WhileEq<>(
            new WhileString("abc"),
            new WhileString("bcd")
    );

    private final WhileEq<WhileArithmeticExpression> WHILE_EQ_3 = new WhileEq<>(
            new WhileConst("12"),
            new WhilePlus(
                    new WhileConst("11"),
                    new WhileIntVar("y")
            )
    );

    @Test
    void getLeft() {
        WhileExpression expectedLeft1 = new WhileTrueConst();
        WhileExpression expectedLeft2 = new WhileString("abc");
        WhileExpression expectedLeft3 = new WhileConst("12");

        assertEquals(expectedLeft1, WHILE_EQ_1.getLeft());
        assertEquals(expectedLeft2, WHILE_EQ_2.getLeft());
        assertEquals(expectedLeft3, WHILE_EQ_3.getLeft());
    }

    @Test
    void getRight() {
        WhileExpression expectedRight1 = new WhileBoolVar("x");
        WhileExpression expectedRight2 = new WhileString("bcd");
        WhileExpression expectedRight3 = new WhilePlus(
                new WhileConst("11"),
                new WhileIntVar("y")
        );

        assertEquals(expectedRight1, WHILE_EQ_1.getRight());
        assertEquals(expectedRight2, WHILE_EQ_2.getRight());
        assertEquals(expectedRight3, WHILE_EQ_3.getRight());
    }

    @Test
    void testToString() {
        assertEquals("((true /\\ x) \\/ (not(true) /\\ not(x)))", WHILE_EQ_1.toString());
        assertEquals("(\"abc\" = \"bcd\")", WHILE_EQ_2.toString());
        assertEquals("(12 = (11 + y))", WHILE_EQ_3.toString());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        map.put(new WhileBoolVar("x"), true);
        map.put(new WhileIntVar("y"), 1);

        assertEquals(true, WHILE_EQ_1.evaluate(map));
        assertEquals(false, WHILE_EQ_2.evaluate(map));
        assertEquals(true, WHILE_EQ_3.evaluate(map));
    }

    @Test
    void testEquals() {
        assertEquals(new WhileEq<>(
                new WhileTrueConst(),
                new WhileBoolVar("x")
        ), WHILE_EQ_1);

        assertEquals(new WhileEq<>(
                new WhileString("abc"),
                new WhileString("bcd")
        ), WHILE_EQ_2);

        assertEquals(new WhileEq<>(
                new WhileConst("12"),
                new WhilePlus(
                        new WhileConst("11"),
                        new WhileIntVar("y")
                )
        ), WHILE_EQ_3);
    }
}