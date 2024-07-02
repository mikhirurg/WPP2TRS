package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * ExpectedTypeException is a class that represents the exception
 * that should be thrown when we detect that there is used the expression of the wrong type
 */
public class ExpectedTypeException extends WhileSyntaxException {

    /**
     * ExpectedTypeException constructor.
     * @param ctx parse rule context
     * @param type1 the expected type
     */
    public ExpectedTypeException(ParserRuleContext ctx, WhileType type1) {
        super(ctx, "Expected type: " + type1);
    }
}
