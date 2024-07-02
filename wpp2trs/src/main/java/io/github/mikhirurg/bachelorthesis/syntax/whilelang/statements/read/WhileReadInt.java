package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;

/**
 * WhileReadInt is a class that represents the While++ read statement for integer variables.
 */
public class WhileReadInt extends WhileRead {

    /**
     * WhileReadInt constructor.
     * @param var the integer variable used in the read statement
     */
    public WhileReadInt(WhileIntVar var) {
        super(var);
    }

    /**
     * The method returns the text representation of the "read" statement for integer variables.
     * @return the text representation of the "read" statement for integer variables
     */
    @Override
    public String toString() {
        return "readInt(" + var.toString() + ")";
    }

    /**
     * The method verifies whether another object represents the same While++ "read" statement for integer variables.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "read" statement for integer variables
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileReadInt.class) {
            return false;
        }

        WhileReadInt otherReadInt = (WhileReadInt) other;

        return this.var.equals(otherReadInt.var);
    }
}
