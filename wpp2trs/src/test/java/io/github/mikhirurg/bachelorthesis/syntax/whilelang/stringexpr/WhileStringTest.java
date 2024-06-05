package io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class WhileStringTest {

    private final WhileString WHILE_STRING_1 = new WhileString("abc");
    private final WhileString WHILE_STRING_2 = new WhileString("Hello world!");
    private final WhileString WHILE_STRING_3 = new WhileString("");


    @Test
    void getValue() {
        assertEquals("abc", WHILE_STRING_1.getValue());
        assertEquals("Hello world!", WHILE_STRING_2.getValue());
        assertEquals("", WHILE_STRING_3.getValue());
    }

    @Test
    void testToString() {
        assertEquals("\"abc\"", WHILE_STRING_1.toString());
        assertEquals("\"Hello world!\"", WHILE_STRING_2.toString());
        assertEquals("\"\"", WHILE_STRING_3.toString());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        assertEquals("abc", WHILE_STRING_1.evaluate(map));
        assertEquals("Hello world!", WHILE_STRING_2.evaluate(map));
        assertEquals("", WHILE_STRING_3.evaluate(map));
    }

    @Test
    void testEquals() {
        assertEquals(new WhileString("abc"), WHILE_STRING_1);
        assertEquals(new WhileString("Hello world!"), WHILE_STRING_2);
        assertEquals(new WhileString(""), WHILE_STRING_3);
        assertNotEquals(new WhileString("asdawd"), WHILE_STRING_3);
    }
}