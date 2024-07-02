package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * IncompatibleTypeException is a class that represents the exception
 * that should be thrown when we detect that there is used the While++ variable of the wrong type.
 */
public class IncompatibleTypeException extends WhileSyntaxException {

    /**
     * IncompatibleTypeException constructor.
     * @param ctx parse rule context
     * @param var the variable of wrong type
     * @param expectedType the expected type for the variable
     */
    public IncompatibleTypeException(ParserRuleContext ctx, WhileVar var, WhileType expectedType) {
        super(ctx, "Wrong type! For variable " + var.getVarName() + " expected type: " +
                expectedType.getName());
    }
}
