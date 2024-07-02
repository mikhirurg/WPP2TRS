package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * ExpectedStatementException is a class that represents the exception
 * that should be thrown when we detect that some While++ statement was expected
 * (for example in the context of the statements composition <code>S1; S2</code>, and <code>S2</code> is missing)
 */
public class ExpectedStatementException extends WhileStatementException {

    /**
     * ExpectedStatementException constructor.
     * @param ctx parse rule context
     */
    public ExpectedStatementException(ParserRuleContext ctx) {
        super(ctx, "Expected statement!");
    }
}
