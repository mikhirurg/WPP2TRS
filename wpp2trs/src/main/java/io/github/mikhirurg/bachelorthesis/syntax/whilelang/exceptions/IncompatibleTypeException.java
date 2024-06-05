package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import org.antlr.v4.runtime.ParserRuleContext;

public class IncompatibleTypeException extends WhileSyntaxException {
    public IncompatibleTypeException(ParserRuleContext ctx, WhileVar var, WhileType expectedType) {
        super(ctx, "Wrong type! For variable " + var.getVarName() + " expected type: " +
                expectedType.getName());
    }
}
