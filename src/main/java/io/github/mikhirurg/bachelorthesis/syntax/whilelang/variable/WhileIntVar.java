package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;

public class WhileIntVar implements WhileVar, WhileArithmeticExpression, Comparable {

    private final String varName;

    public WhileIntVar(String varName) {
        this.varName = varName;
    }

    @Override
    public String getVarName() {
        return varName;
    }

    @Override
    public int hashCode() {
        return varName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof WhileIntVar)) {
            return false;
        }

        WhileIntVar var = (WhileIntVar) obj;

        return varName.equals(var.varName);
    }

    @Override
    public String textRepresentation() {
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
}
