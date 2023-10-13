package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileBoolVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WhileAndTest {

    private final WhileAnd WHILE_AND_1 = new WhileAnd(
            new WhileTrueConst(),
            new WhileFalseConst()
    );

    private final WhileAnd WHILE_AND_2 = new WhileAnd(
            new WhileTrueConst(),
            new WhileBoolVar("x")
    );

    private final WhileAnd WHILE_AND_3 = new WhileAnd(
            new WhileOr(
                    new WhileFalseConst(),
                    new WhileBoolVar("y")
            ),
            new WhileBoolVar("x")
    );

    @Test
    void getLeft() {
        WhileBooleanExpression expectedLeft1 = new WhileTrueConst();
        WhileBooleanExpression expectedLeft2 = new WhileTrueConst();
        WhileBooleanExpression expectedLeft3 = new WhileOr(
                new WhileFalseConst(),
                new WhileBoolVar("y")
        );

        assertEquals(expectedLeft1, WHILE_AND_1.getLeft());
        assertEquals(expectedLeft2, WHILE_AND_2.getLeft());
        assertEquals(expectedLeft3, WHILE_AND_3.getLeft());
    }

    @Test
    void getRight() {
        WhileBooleanExpression expectedRight1 = new WhileFalseConst();
        WhileBooleanExpression expectedRight2 = new WhileBoolVar("x");
        WhileBooleanExpression expectedRight3 = new WhileBoolVar("x");

        assertEquals(expectedRight1, WHILE_AND_1.getRight());
        assertEquals(expectedRight2, WHILE_AND_2.getRight());
        assertEquals(expectedRight3, WHILE_AND_3.getRight());
    }

    @Test
    void testToString() {
        assertEquals("(true ^ false)", WHILE_AND_1.toString());
        assertEquals("(true ^ x)", WHILE_AND_2.toString());
        assertEquals("((false V y) ^ x)", WHILE_AND_3.toString());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        map.put(new WhileBoolVar("x"), true);
        map.put(new WhileBoolVar("y"), false);

        assertEquals(false, WHILE_AND_1.evaluate(map));
        assertEquals(true, WHILE_AND_2.evaluate(map));
        assertEquals(false, WHILE_AND_3.evaluate(map));
    }

    @Test
    void testEquals() {
        assertEquals(new WhileAnd(
                new WhileTrueConst(),
                new WhileFalseConst()
        ), WHILE_AND_1);

        assertEquals(new WhileAnd(
                new WhileTrueConst(),
                new WhileBoolVar("x")
        ), WHILE_AND_2);

        assertEquals(new WhileAnd(
                new WhileOr(
                        new WhileFalseConst(),
                        new WhileBoolVar("y")
                ),
                new WhileBoolVar("x")
        ), WHILE_AND_3);
    }
}