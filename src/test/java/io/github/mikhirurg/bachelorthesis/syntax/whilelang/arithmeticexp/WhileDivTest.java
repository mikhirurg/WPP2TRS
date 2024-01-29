package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WhileDivTest {

    // "(10 / 5)" = 2
    private final WhileDiv WHILE_DIV_1 = new WhileDiv(
            new WhileConst("10"),
            new WhileConst("5")
    );

    // "(x / (5 - 2))" = 3
    private final WhileDiv WHILE_DIV_2 = new WhileDiv(
            new WhileIntVar("x"),
            new WhileSub(
                    new WhileConst("5"),
                    new WhileConst("2")
            )
    );

    // "((2 * x) / (x + y))" = 1
    private final WhileDiv WHILE_DIV_3 = new WhileDiv(
            new WhileMult(
                    new WhileConst("2"),
                    new WhileIntVar("x")
            ),
            new WhilePlus(
                    new WhileIntVar("x"),
                    new WhileIntVar("y")
            )
    );

    @Test
    void getLeft() {
        WhileExpression expectedLeft1 = new WhileConst("10");
        assertEquals(expectedLeft1, WHILE_DIV_1.getLeft());

        WhileExpression expectedLeft2 = new WhileIntVar("x");
        assertEquals(expectedLeft2, WHILE_DIV_2.getLeft());

        WhileExpression expectedLeft3 = new WhileMult(
                new WhileConst("2"),
                new WhileIntVar("x")
        );
        assertEquals(expectedLeft3, WHILE_DIV_3.getLeft());
    }

    @Test
    void getRight() {
        WhileExpression expectedRight1 = new WhileConst("5");
        assertEquals(expectedRight1, WHILE_DIV_1.getRight());

        WhileExpression expectedRight2 = new WhileSub(
                new WhileConst("5"),
                new WhileConst("2")
        );
        assertEquals(expectedRight2, WHILE_DIV_2.getRight());

        WhileExpression expectedRight3 = new WhilePlus(
                new WhileIntVar("x"),
                new WhileIntVar("y")
        );
        assertEquals(expectedRight3, WHILE_DIV_3.getRight());
    }

    @Test
    void testToString() {
        assertEquals("(10 / 5)", WHILE_DIV_1.toString());
        assertEquals("(x / (5 - 2))", WHILE_DIV_2.toString());
        assertEquals("((2 * x) / (x + y))", WHILE_DIV_3.toString());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        map.put(new WhileIntVar("x"), 11);
        map.put(new WhileIntVar("y"), 2);

        assertEquals(2, WHILE_DIV_1.evaluate(map));
        assertEquals(3, WHILE_DIV_2.evaluate(map));
        assertEquals(1, WHILE_DIV_3.evaluate(map));
    }

    @Test
    void testEquals() {
        WhileDiv expected = new WhileDiv(
                new WhileMult(
                        new WhileConst("2"),
                        new WhileIntVar("x")
                ),
                new WhilePlus(
                        new WhileIntVar("x"),
                        new WhileIntVar("y")
                )
        );

        assertEquals(expected, WHILE_DIV_3);
    }
}