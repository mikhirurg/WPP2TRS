package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * DuplicateVariableDeclarationException is a class that represents the exception
 * that should be thrown when we detect that some While++ variable was declared twice in the same area of visibility
 */
public class DuplicateVariableDeclarationException extends WhileSyntaxException {

    /**
     * DuplicateVariableDeclarationException constructor.
     * @param ctx parse rule context
     * @param var the variable that was declared twice
     */
    public DuplicateVariableDeclarationException(ParserRuleContext ctx, WhileVar var) {
        super(ctx, "Error: variable " + var.getVarName() + " was already declared!");
    }
}
