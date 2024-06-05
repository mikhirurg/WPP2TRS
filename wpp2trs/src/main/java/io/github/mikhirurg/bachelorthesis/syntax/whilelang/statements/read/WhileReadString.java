package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

public class WhileReadString extends WhileRead {
    public WhileReadString(WhileVar var) {
        super(var);
    }

    @Override
    public String toString() {
        return "readString(" + var.toString() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileReadString.class) {
            return false;
        }

        WhileReadString otherReadString = (WhileReadString) other;

        return this.var.equals(otherReadString.var);
    }
}
