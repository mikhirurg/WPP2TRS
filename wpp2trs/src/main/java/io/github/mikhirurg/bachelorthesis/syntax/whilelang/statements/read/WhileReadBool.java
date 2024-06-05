package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

public class WhileReadBool extends WhileRead {
    public WhileReadBool(WhileVar var) {
        super(var);
    }

    @Override
    public String toString() {
        return "readBool(" + var.toString() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileReadBool.class) {
            return false;
        }

        WhileReadBool otherReadBool = (WhileReadBool) other;

        return this.var.equals(otherReadBool.var);
    }
}
