package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhileNumberTest {

    WhileNumber WHILE_NUMBER = new WhileNumber("10");

    @Test
    void getValue() {
        assertEquals(10, WHILE_NUMBER.getValue());
    }

    @Test
    void testEquals() {
        WhileNumber other = new WhileNumber("10");
        assertEquals(other, WHILE_NUMBER);
    }
}