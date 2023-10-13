package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.exceptions;

import io.github.mikhirurg.bachelorthesis.syntax.WhileSyntaxException;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;

public class ExpectedTypeException extends WhileSyntaxException {
    public ExpectedTypeException(WhileType type1) {
        super("Expected type: " + type1);
    }
}
