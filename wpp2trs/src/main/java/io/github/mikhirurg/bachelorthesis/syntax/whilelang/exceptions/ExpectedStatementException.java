package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import org.antlr.v4.runtime.ParserRuleContext;

public class ExpectedStatementException extends WhileStatementException {
    public ExpectedStatementException(ParserRuleContext ctx) {
        super(ctx, "Expected statement!");
    }
}
