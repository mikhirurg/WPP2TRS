package io.github.mikhirurg.bachelorthesis;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import org.junit.jupiter.api.Test;

class ProgramBuilderTest {

    @Test
    void testTypeDeclareInt() {
        String program = "int x = 1";

        WhileStatement statement = ProgramBuilder.parseProgram(program);

    }

}