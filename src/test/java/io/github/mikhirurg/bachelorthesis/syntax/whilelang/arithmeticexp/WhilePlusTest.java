package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WhilePlusTest {

    private final WhilePlus WHILE_PLUS_1 = new WhilePlus(
            new WhileConst("10"),
            new WhileConst("2")
    );

    private final WhilePlus WHILE_PLUS_2 = new WhilePlus(
            new WhileMult(
                    new WhileConst("1"),
                    new WhileConst("2")
            ),
            new WhileConst("10")
    );

    private final WhilePlus WHILE_PLUS_3 = new WhilePlus(
            new WhilePlus(
                    new WhileConst("1"),
                    new WhileIntVar("x")
            ),
            new WhileIntVar("y")
    );

    @Test
    void getLeft() {
        WhileConst expectedLeft1 = new WhileConst("10");
        WhileMult expectedLeft2 = new WhileMult(
                new WhileConst("1"),
                new WhileConst("2")
        );
        WhilePlus expectedLeft3 = new WhilePlus(
                new WhileConst("1"),
                new WhileIntVar("x")
        );

        assertEquals(expectedLeft1, WHILE_PLUS_1.getLeft());
        assertEquals(expectedLeft2, WHILE_PLUS_2.getLeft());
        assertEquals(expectedLeft3, WHILE_PLUS_3.getLeft());
    }

    @Test
    void getRight() {
        WhileConst expectedRight1 = new WhileConst("2");
        WhileConst expectedRight2 = new WhileConst("10");
        WhileIntVar expectedRight3 = new WhileIntVar("y");

        assertEquals(expectedRight1, WHILE_PLUS_1.getRight());
        assertEquals(expectedRight2, WHILE_PLUS_2.getRight());
        assertEquals(expectedRight3, WHILE_PLUS_3.getRight());
    }

    @Test
    void textRepresentation() {
        assertEquals("(10 + 2)", WHILE_PLUS_1.toString());
        assertEquals("((1 * 2) + 10)", WHILE_PLUS_2.toString());
        assertEquals("((1 + x) + y)", WHILE_PLUS_3.toString());
    }

    @Test
    void testEvaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        map.put(new WhileIntVar("x"), 3);
        map.put(new WhileIntVar("y"), 4);

        assertEquals(12, WHILE_PLUS_1.evaluate(map));
        assertEquals(12, WHILE_PLUS_2.evaluate(map));
        assertEquals(8, WHILE_PLUS_3.evaluate(map));
    }

    @Test
    void testEquals() {
        assertEquals(new WhilePlus(
                new WhileConst("10"),
                new WhileConst("2")
        ), WHILE_PLUS_1);

        assertEquals(new WhilePlus(
                new WhileMult(
                        new WhileConst("1"),
                        new WhileConst("2")
                ),
                new WhileConst("10")
        ), WHILE_PLUS_2);

        assertEquals(new WhilePlus(
                new WhilePlus(
                        new WhileConst("1"),
                        new WhileIntVar("x")
                ),
                new WhileIntVar("y")
        ), WHILE_PLUS_3);
    }
}