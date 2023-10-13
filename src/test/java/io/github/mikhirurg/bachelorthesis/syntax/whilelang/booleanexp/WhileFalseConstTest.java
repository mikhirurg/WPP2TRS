package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WhileFalseConstTest {

    private final WhileFalseConst WHILE_FALSE = new WhileFalseConst();

    @Test
    void testToString() {
        assertEquals("false", WHILE_FALSE.toString());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        assertEquals(false, WHILE_FALSE.evaluate(map));
    }

    @Test
    void testEquals() {
        assertEquals(new WhileFalseConst(), WHILE_FALSE);
    }
}