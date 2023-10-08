package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileString;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileStringExpression;

public class WhileStringVar extends WhileString implements WhileVar, WhileStringExpression {

    private final String varName;

    public WhileStringVar(String varName) {
        super("");
        this.varName = varName;
    }

    @Override
    public WhileType getType() {
        return WhileType.STRING;
    }

    @Override
    public String getVarName() {
        return varName;
    }

    @Override
    public String textRepresentation() {
        return varName;
    }
}
