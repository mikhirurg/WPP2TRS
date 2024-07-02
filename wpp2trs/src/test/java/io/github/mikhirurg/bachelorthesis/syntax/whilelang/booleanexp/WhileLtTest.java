package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileConst;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhilePlus;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WhileLtTest {

    private final WhileLt WHILE_LT_1 = new WhileLt(
            new WhileConst("10"),
            new WhileConst("20")
    );

    private final WhileLt WHILE_LT_2 = new WhileLt(
            new WhileConst("30"),
            new WhileIntVar("x")
    );

    private final WhileLt WHILE_LT_3 = new WhileLt(
            new WhileConst("10"),
            new WhilePlus(
                    new WhileConst("5"),
                    new WhileIntVar("y")
            )
    );


    @Test
    void getLeft() {
        WhileExpression expectedLeft1 = new WhileConst("10");
        WhileExpression expectedLeft2 = new WhileConst("30");
        WhileExpression expectedLeft3 = new WhileConst("10");

        assertEquals(expectedLeft1, WHILE_LT_1.getLeft());
        assertEquals(expectedLeft2, WHILE_LT_2.getLeft());
        assertEquals(expectedLeft3, WHILE_LT_3.getLeft());
    }

    @Test
    void getRight() {
        WhileExpression expectedRight1 = new WhileConst("20");
        WhileExpression expectedRight2 = new WhileIntVar("x");
        WhileExpression expectedRight3 = new WhilePlus(
                new WhileConst("5"),
                new WhileIntVar("y")
        );

        assertEquals(expectedRight1, WHILE_LT_1.getRight());
        assertEquals(expectedRight2, WHILE_LT_2.getRight());
        assertEquals(expectedRight3, WHILE_LT_3.getRight());
    }

    @Test
    void testToString() {
        assertEquals("(10 < 20)", WHILE_LT_1.toString());
        assertEquals("(30 < x)", WHILE_LT_2.toString());
        assertEquals("(10 < (5 + y))", WHILE_LT_3.toString());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        map.put(new WhileIntVar("x"), 20);
        map.put(new WhileIntVar("y"), 5);

        assertEquals(true, WHILE_LT_1.evaluate(map));
        assertEquals(false, WHILE_LT_2.evaluate(map));
        assertEquals(false, WHILE_LT_3.evaluate(map));
    }

    @Test
    void testEquals() {
        assertEquals(new WhileLt(
                new WhileConst("10"),
                new WhileConst("20")
        ), WHILE_LT_1);

        assertEquals(new WhileLt(
                new WhileConst("30"),
                new WhileIntVar("x")
        ), WHILE_LT_2);

        assertEquals(new WhileLt(
                new WhileConst("10"),
                new WhilePlus(
                        new WhileConst("5"),
                        new WhileIntVar("y")
                )
        ), WHILE_LT_3);
    }
}