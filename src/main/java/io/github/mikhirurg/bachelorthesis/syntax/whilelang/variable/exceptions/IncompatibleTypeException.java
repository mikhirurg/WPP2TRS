package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.exceptions;

import io.github.mikhirurg.bachelorthesis.syntax.WhileSyntaxException;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVarType;

public class IncompatibleTypeException extends WhileSyntaxException {
    public IncompatibleTypeException(WhileVar var, WhileVarType type) {
        super("Wrong type! For variable " + var.getVarName() + " expected type: " +
                type.getName() + ", found: " + var.getType().getName());
    }
}
