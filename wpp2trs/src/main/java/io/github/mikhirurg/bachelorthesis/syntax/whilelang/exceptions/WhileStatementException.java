package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import org.antlr.v4.runtime.ParserRuleContext;

public class WhileStatementException extends WhileSyntaxException {
    public WhileStatementException(ParserRuleContext ctx, String message) {
        super(ctx, message);
    }
}
