package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * WhileSyntaxException is a basic class for all While++ syntax-related exceptions
 */
public class WhileSyntaxException extends RuntimeException {

    /**
     * WhileSyntaxException constructor.
     * @param ctx parse rule context
     * @param message the exception message
     */
    public WhileSyntaxException(ParserRuleContext ctx, String message) {
        super("Line: " + ctx.getStart().getLine() +
                ", column: " + ctx.getStart().getCharPositionInLine() + " " +
                message);
    }
}
