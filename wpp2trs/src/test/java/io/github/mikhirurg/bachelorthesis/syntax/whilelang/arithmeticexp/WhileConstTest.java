package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WhileConstTest {

    private final WhileConst WHILE_CONST = new WhileConst("10");

    @Test
    void getNumber() {
        WhileNumber number = new WhileNumber("10");
        assertEquals(number, WHILE_CONST.getNumber());
    }

    @Test
    void textRepresentation() {
        assertEquals("10", WHILE_CONST.toString());
    }

    @Test
    void evaluate() {
        Map<WhileVar, Object> map = new HashMap<>();
        assertEquals(10, WHILE_CONST.evaluate(map));
    }

    @Test
    void testEquals() {
        WhileConst other = new WhileConst("10");
        assertEquals(other, WHILE_CONST);
    }
}