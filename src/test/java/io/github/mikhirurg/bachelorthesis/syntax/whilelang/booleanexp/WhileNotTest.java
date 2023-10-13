package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileString;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileBoolVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileStringVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WhileNotTest {

    private final WhileNot WHILE_NOT_1 = new WhileNot(new WhileFalseConst());
    private final WhileNot WHILE_NOT_2 = new WhileNot(
            new WhileOr(new WhileFalseConst(),
                    new WhileBoolVar("x"))
    );
    private final WhileNot WHILE_NOT_3 = new WhileNot(new WhileEq<>(
            new WhileString("abc"),
            new WhileStringVar("y")
    ));


    @Test
    void getExpression() {
        WhileExpression expected1 = new WhileFalseConst();
        WhileExpression expected2 = new WhileOr(new WhileFalseConst(), new WhileBoolVar("x"));
        WhileExpression expected3 = new WhileEq<>(new WhileString("abc"), new WhileStringVar("y"));

        assertEquals(expected1, WHILE_NOT_1.getExpression());
        assertEquals(expected2, WHILE_NOT_2.getExpression());
        assertEquals(expected3, WHILE_NOT_3.getExpression());
    }

    @Test
    void testToString() {
        assertEquals("not(false)", WHILE_NOT_1.toString());
        assertEquals("not((false V x))", WHILE_NOT_2.toString());
        assertEquals("not((\"abc\" = y))", WHILE_NOT_3.toString());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        map.put(new WhileBoolVar("x"), true);
        map.put(new WhileStringVar("y"), "abc");

        assertEquals(true, WHILE_NOT_1.evaluate(map));
        assertEquals(false, WHILE_NOT_2.evaluate(map));
        assertEquals(false, WHILE_NOT_3.evaluate(map));
    }

    @Test
    void testEquals() {
        assertEquals(new WhileNot(new WhileFalseConst()), WHILE_NOT_1);

        assertEquals(new WhileNot(
                new WhileOr(new WhileFalseConst(),
                        new WhileBoolVar("x"))
        ), WHILE_NOT_2);

        assertEquals(new WhileNot(new WhileEq<>(
                new WhileString("abc"),
                new WhileStringVar("y")
        )), WHILE_NOT_3);
    }
}