package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class WhileTrueConstTest {

    private final WhileTrueConst WHILE_TRUE = new WhileTrueConst();

    @Test
    void testToString() {
        assertEquals("true", WHILE_TRUE.toString());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        assertEquals(true, WHILE_TRUE.evaluate(map));
    }

    @Test
    void testEquals() {
        assertEquals(new WhileTrueConst(), WHILE_TRUE);
    }
}