package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileBooleanExpression;

public class WhileBoolVar implements WhileVar, WhileBooleanExpression {

    private final String varName;

    public WhileBoolVar(String varName) {
        this.varName = varName;
    }

    @Override
    public String textRepresentation() {
        return varName;
    }

    @Override
    public WhileType getType() {
        return WhileType.BOOL;
    }

    @Override
    public String getVarName() {
        return varName;
    }
}
