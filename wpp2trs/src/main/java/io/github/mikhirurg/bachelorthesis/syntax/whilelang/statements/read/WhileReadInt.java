package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

public class WhileReadInt extends WhileRead {
    public WhileReadInt(WhileVar var) {
        super(var);
    }

    @Override
    public String toString() {
        return "readInt(" + var.toString() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileReadInt.class) {
            return false;
        }

        WhileReadInt otherReadInt = (WhileReadInt) other;

        return this.var.equals(otherReadInt.var);
    }
}
