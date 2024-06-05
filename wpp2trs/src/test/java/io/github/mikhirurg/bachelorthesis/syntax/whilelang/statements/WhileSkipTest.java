package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WhileSkipTest {

    private final WhileSkip WHILE_SKIP = new WhileSkip();

    @Test
    void testToString() {
        assertEquals("skip", WHILE_SKIP.toString());
    }

    @Test
    void acceptTRSPrinter() {
    }

    @Test
    void testEquals() {
        assertEquals(new WhileSkip(), WHILE_SKIP);
    }
}