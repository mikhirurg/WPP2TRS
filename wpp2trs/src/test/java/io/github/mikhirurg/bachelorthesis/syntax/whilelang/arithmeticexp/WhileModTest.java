package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WhileModTest {

    // "(11 % 2)" = 1
    private final WhileMod WHILE_MOD_1 = new WhileMod(
            new WhileConst("11"),
            new WhileConst("2")
    );

    // "(x % y)"
    private final WhileMod WHILE_MOD_2 = new WhileMod(
            new WhileIntVar("x"),
            new WhileIntVar("y")
    );

    // "((10 / 3) % (x + y))"
    private final WhileMod WHILE_MOD_3 = new WhileMod(
            new WhileDiv(
                    new WhileConst("10"),
                    new WhileConst("3")
            ),
            new WhilePlus(
                    new WhileIntVar("x"),
                    new WhileIntVar("y")
            )
    );

    @Test
    void getLeft() {
        WhileExpression expectedLeft1 = new WhileConst("11");
        assertEquals(expectedLeft1, WHILE_MOD_1.getLeft());

        WhileExpression expectedLeft2 = new WhileIntVar("x");
        assertEquals(expectedLeft2, WHILE_MOD_2.getLeft());

        WhileExpression expectedLeft3 = new WhileDiv(
                new WhileConst("10"),
                new WhileConst("3")
        );
        assertEquals(expectedLeft3, WHILE_MOD_3.getLeft());
    }

    @Test
    void getRight() {
        WhileExpression expectedRight1 = new WhileConst("2");
        assertEquals(expectedRight1, WHILE_MOD_1.getRight());

        WhileExpression expectedRight2 = new WhileIntVar("y");
        assertEquals(expectedRight2, WHILE_MOD_2.getRight());

        WhileExpression expectedRight3 = new WhilePlus(
                new WhileIntVar("x"),
                new WhileIntVar("y")
        );
        assertEquals(expectedRight3, WHILE_MOD_3.getRight());
    }

    @Test
    void testToString() {
        assertEquals("(11 % 2)", WHILE_MOD_1.toString());
        assertEquals("(x % y)", WHILE_MOD_2.toString());
        assertEquals("((10 / 3) % (x + y))", WHILE_MOD_3.toString());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        map.put(new WhileIntVar("x"), 7);
        map.put(new WhileIntVar("y"), 3);

        assertEquals(1, WHILE_MOD_1.evaluate(map));
        assertEquals(1, WHILE_MOD_2.evaluate(map));
        assertEquals(3, WHILE_MOD_3.evaluate(map));
    }

    @Test
    void testEquals() {
        WhileMod expected = new WhileMod(
                new WhileDiv(
                        new WhileConst("10"),
                        new WhileConst("3")
                ),
                new WhilePlus(
                        new WhileIntVar("x"),
                        new WhileIntVar("y")
                )
        );

        assertEquals(expected, WHILE_MOD_3);
    }
}