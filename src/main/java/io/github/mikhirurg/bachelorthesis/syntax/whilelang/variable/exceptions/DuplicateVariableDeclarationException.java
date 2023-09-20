package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.exceptions;

import io.github.mikhirurg.bachelorthesis.syntax.WhileSyntaxException;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

public class DuplicateVariableDeclarationException extends WhileSyntaxException {
    public DuplicateVariableDeclarationException(WhileVar var) {
        super("Error: variable " + var.getVarName() + " was already declared!");
    }
}
