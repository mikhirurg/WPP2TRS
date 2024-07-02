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

class WhileGeqTest {

    private final WhileGeq WHILE_GEQ_1 = new WhileGeq(
            new WhileConst("10"),
            new WhileConst("20")
    );

    private final WhileGeq WHILE_GEQ_2 = new WhileGeq(
            new WhileConst("30"),
            new WhileIntVar("x")
    );

    private final WhileGeq WHILE_GEQ_3 = new WhileGeq(
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

        assertEquals(expectedLeft1, WHILE_GEQ_1.getLeft());
        assertEquals(expectedLeft2, WHILE_GEQ_2.getLeft());
        assertEquals(expectedLeft3, WHILE_GEQ_3.getLeft());
    }

    @Test
    void getRight() {
        WhileExpression expectedRight1 = new WhileConst("20");
        WhileExpression expectedRight2 = new WhileIntVar("x");
        WhileExpression expectedRight3 = new WhilePlus(
                new WhileConst("5"),
                new WhileIntVar("y")
        );

        assertEquals(expectedRight1, WHILE_GEQ_1.getRight());
        assertEquals(expectedRight2, WHILE_GEQ_2.getRight());
        assertEquals(expectedRight3, WHILE_GEQ_3.getRight());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        map.put(new WhileIntVar("x"), 50);
        map.put(new WhileIntVar("y"), 5);

        assertEquals(false, WHILE_GEQ_1.evaluate(map));
        assertEquals(false, WHILE_GEQ_2.evaluate(map));
        assertEquals(true, WHILE_GEQ_3.evaluate(map));
    }

    @Test
    void testToString() {
        assertEquals("(10 >= 20)", WHILE_GEQ_1.toString());
        assertEquals("(30 >= x)", WHILE_GEQ_2.toString());
        assertEquals("(10 >= (5 + y))", WHILE_GEQ_3.toString());
    }

    @Test
    void testEquals() {
        assertEquals(new WhileGeq(
                new WhileConst("10"),
                new WhileConst("20")
        ), WHILE_GEQ_1);

        assertEquals(new WhileGeq(
                new WhileConst("30"),
                new WhileIntVar("x")
        ), WHILE_GEQ_2);

        assertEquals(new WhileGeq(
                new WhileConst("10"),
                new WhilePlus(
                        new WhileConst("5"),
                        new WhileIntVar("y")
                )
        ), WHILE_GEQ_3);
    }
}