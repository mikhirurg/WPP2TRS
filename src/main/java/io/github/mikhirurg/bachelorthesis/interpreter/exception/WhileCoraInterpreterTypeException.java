package io.github.mikhirurg.bachelorthesis.interpreter.exception;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;

public class WhileCoraInterpreterTypeException extends RuntimeException {
    public WhileCoraInterpreterTypeException(WhileType expected, WhileType actual) {
        super("Expected entity of the type \"" + expected.getName() + "\", found: \"" + actual.getName() + "\"");
    }
}
