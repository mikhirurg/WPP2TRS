package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * WhileStatementException is a basic class for all While++ statements-related exceptions
 */
public class WhileStatementException extends WhileSyntaxException {

    /**
     * WhileStatementException constructor.
     * @param ctx parse rule context
     * @param message the exception message
     */
    public WhileStatementException(ParserRuleContext ctx, String message) {
        super(ctx, message);
    }
}
