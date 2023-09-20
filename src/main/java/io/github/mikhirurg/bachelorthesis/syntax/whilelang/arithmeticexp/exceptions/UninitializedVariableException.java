package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.exceptions;

public class UninitializedVariableException extends WhileArithmeticException {
    public UninitializedVariableException(String var) {
        super("Variable " + var + " is not initialized!");
    }
}
