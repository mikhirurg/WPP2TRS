package io.github.mikhirurg.bachelorthesis.syntax.whilelang.exceptions;

import org.antlr.v4.runtime.ParserRuleContext;

/**
 * VariableNotDeclaredException is a class that represents the exception
 * that should be thrown when we detect that the While++ variable has not yet been declared.
 */
public class VariableNotDeclaredException extends WhileSyntaxException {

    /**
     * VariableNotDeclaredException constructor.
     * @param ctx parse rule context
     * @param name the name of the non-declared variable
     */
    public VariableNotDeclaredException(ParserRuleContext ctx, String name) {
        super(ctx, "Variable \"" + name + "\" is not declared!");
    }
}
