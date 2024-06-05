package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileStringExpression;
import java.util.Map;

public class WhileStringVar extends WhileVar implements WhileStringExpression {

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
    public String toString() {
        return varName;
    }

    @Override
    public String evaluate(Map<WhileVar, Object> map) {
        return (String) map.get(this);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileStringVar.class) {
            return false;
        }

        WhileStringVar otherLeq = (WhileStringVar) other;

        return this.varName.equals(otherLeq.varName);
    }
}
