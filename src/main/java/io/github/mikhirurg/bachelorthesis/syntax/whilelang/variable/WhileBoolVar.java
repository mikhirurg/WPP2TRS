package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileBooleanExpression;

public class WhileBoolVar implements WhileVar, WhileBooleanExpression {
    @Override
    public String textRepresentation() {
        return null;
    }

    @Override
    public WhileVarType getType() {
        return WhileVarType.BOOL;
    }

    @Override
    public String getVarName() {
        return null;
    }
}
