package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileBooleanExpression;

import java.util.Map;

public class WhileBoolVar extends WhileVar implements WhileBooleanExpression {

    public WhileBoolVar(String varName) {
        super(varName);
    }

    @Override
    public String toString() {
        return varName;
    }

    @Override
    public WhileType getType() {
        return WhileType.BOOL;
    }

    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return (Boolean) map.get(this);
    }
}
