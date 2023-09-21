package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.exceptions;

import io.github.mikhirurg.bachelorthesis.syntax.WhileSyntaxException;

public class VariableNotDeclaredException extends WhileSyntaxException {
    public VariableNotDeclaredException(String name) {
        super("Variable \"" + name + "\" is not declared!");
    }
}
