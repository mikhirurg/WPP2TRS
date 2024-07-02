package io.github.mikhirurg.bachelorthesis.interpreter.exception;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;

/**
 * WhileCoraInterpreterTypeException is a class that represents the incompatible type exceptions in the WPP2TRS console application.
 */
public class WhileCoraInterpreterTypeException extends RuntimeException {

    /**
     * WhileCoraInterpreterTypeException constructor.
     * @param expected the expected type
     * @param actual the type that was found
     */
    public WhileCoraInterpreterTypeException(WhileType expected, WhileType actual) {
        super("Expected entity of the type \"" + expected.getName() + "\", found: \"" + actual.getName() + "\"");
    }
}
