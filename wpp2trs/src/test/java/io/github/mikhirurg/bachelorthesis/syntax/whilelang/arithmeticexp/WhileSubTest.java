package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WhileSubTest {

    private final WhileSub WHILE_SUB_1 = new WhileSub(
            new WhileConst("10"),
            new WhileConst("2")
    );

    private final WhileSub WHILE_SUB_2 = new WhileSub(
            new WhileMult(
                    new WhileConst("1"),
                    new WhileConst("2")
            ),
            new WhileConst("10")
    );

    private final WhileSub WHILE_SUB_3 = new WhileSub(
            new WhileSub(
                    new WhileConst("1"),
                    new WhileIntVar("x")
            ),
            new WhileIntVar("y")
    );

    @Test
    void getLeft() {
        WhileExpression expectedLeft1 = new WhileConst("10");
        WhileExpression expectedLeft2 = new WhileMult(
                new WhileConst("1"),
                new WhileConst("2")
        );
        WhileExpression expectedLeft3 = new WhileSub(
                new WhileConst("1"),
                new WhileIntVar("x")
        );

        assertEquals(expectedLeft1, WHILE_SUB_1.getLeft());
        assertEquals(expectedLeft2, WHILE_SUB_2.getLeft());
        assertEquals(expectedLeft3, WHILE_SUB_3.getLeft());
    }

    @Test
    void getRight() {
        WhileExpression expectedRight1 = new WhileConst("2");
        WhileExpression expectedRight2 = new WhileConst("10");
        WhileExpression expectedRight3 = new WhileIntVar("y");

        assertEquals(expectedRight1, WHILE_SUB_1.getRight());
        assertEquals(expectedRight2, WHILE_SUB_2.getRight());
        assertEquals(expectedRight3, WHILE_SUB_3.getRight());
    }

    @Test
    void testToString() {
        assertEquals("(10 - 2)", WHILE_SUB_1.toString());
        assertEquals("((1 * 2) - 10)", WHILE_SUB_2.toString());
        assertEquals("((1 - x) - y)", WHILE_SUB_3.toString());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        map.put(new WhileIntVar("x"), 3);
        map.put(new WhileIntVar("y"), 4);

        assertEquals(8, WHILE_SUB_1.evaluate(map));
        assertEquals(-8, WHILE_SUB_2.evaluate(map));
        assertEquals(-6, WHILE_SUB_3.evaluate(map));
    }

    @Test
    void testEquals() {
        assertEquals(new WhileSub(
                new WhileConst("10"),
                new WhileConst("2")
        ), WHILE_SUB_1);

        assertEquals(new WhileSub(
                        new WhileMult(
                                new WhileConst("1"),
                                new WhileConst("2")
                        ), new WhileConst("10")
        ), WHILE_SUB_2);

        assertEquals(new WhileSub(
                new WhileSub(
                        new WhileConst("1"),
                        new WhileIntVar("x")
                ), new WhileIntVar("y")
        ), WHILE_SUB_3);
    }
}