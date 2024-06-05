package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import org.antlr.v4.runtime.ParserRuleContext;

public class ExpectedTypeException extends WhileSyntaxException {
    public ExpectedTypeException(ParserRuleContext ctx, WhileType type1) {
        super(ctx, "Expected type: " + type1);
    }
}
