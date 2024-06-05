package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.antlr.v4.runtime.ParserRuleContext;

public class DuplicateVariableDeclarationException extends WhileSyntaxException {
    public DuplicateVariableDeclarationException(ParserRuleContext ctx, WhileVar var) {
        super(ctx, "Error: variable " + var.getVarName() + " was already declared!");
    }
}
