package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;

public abstract class WhileVar implements WhileExpression {

    protected final String varName;

    public WhileVar(String varName) {
        this.varName = varName;
    }

    @Override
    public boolean equals(Object other) {

        if (other.getClass() != getClass()) {
            return false;
        }

        WhileVar otherVar = (WhileVar) other;
        return varName.equals(otherVar.varName);
    }

    @Override
    public int hashCode() {
        return varName.hashCode();
    }

    public WhileType getType() {
        return null;
    }

    public String getVarName() {
        return varName;
    }

}
