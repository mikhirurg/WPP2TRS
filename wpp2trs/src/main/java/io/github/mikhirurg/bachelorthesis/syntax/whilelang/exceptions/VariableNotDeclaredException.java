package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import org.antlr.v4.runtime.ParserRuleContext;

public class VariableNotDeclaredException extends WhileSyntaxException {
    public VariableNotDeclaredException(ParserRuleContext ctx, String name) {
        super(ctx, "Variable \"" + name + "\" is not declared!");
    }
}
