package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

public class UninitializedVariableException extends WhileArithmeticException {
    public UninitializedVariableException(String var) {
        super("Variable " + var + " is not initialized!");
    }
}