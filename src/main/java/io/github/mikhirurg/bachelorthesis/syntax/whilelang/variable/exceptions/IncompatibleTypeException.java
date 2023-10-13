package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.exceptions;

import io.github.mikhirurg.bachelorthesis.syntax.WhileSyntaxException;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;

public class IncompatibleTypeException extends WhileSyntaxException {
    public IncompatibleTypeException(WhileVar var, WhileType expectedType) {
        super("Wrong type! For variable " + var.getVarName() + " expected type: " +
                expectedType.getName());
    }
}
