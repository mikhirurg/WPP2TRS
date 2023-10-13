package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileConst;

import java.util.Map;

public class WhileIntVar extends WhileVar implements WhileArithmeticExpression, Comparable {

    public WhileIntVar(String varName) {
        super(varName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof WhileIntVar var)) {
            return false;
        }

        return varName.equals(var.varName);
    }

    @Override
    public String toString() {
        return varName;
    }

    @Override
    public int compareTo(Object o) {
        WhileIntVar other = (WhileIntVar) o;
        return varName.compareTo(other.getVarName());
    }

    @Override
    public WhileType getType() {
        return WhileType.INT;
    }

    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return (Integer) map.get(this);
    }
}
