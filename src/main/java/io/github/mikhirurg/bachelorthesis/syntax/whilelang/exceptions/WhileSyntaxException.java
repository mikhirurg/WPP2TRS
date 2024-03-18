package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import org.antlr.v4.runtime.ParserRuleContext;

public class WhileSyntaxException extends RuntimeException {
    public WhileSyntaxException(ParserRuleContext ctx, String message) {
        super("Line: " + ctx.getStart().getLine() +
                ", column: " + ctx.getStart().getCharPositionInLine() + " " +
                message);
    }
}
