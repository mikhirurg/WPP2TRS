package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileBoolVar;

/**
 * WhileReadBool is a class that represents the While++ read statement for boolean variables.
 */
public class WhileReadBool extends WhileRead {

    /**
     * WhileReadBool constructor.
     * @param var the boolean variable used in the read statement
     */
    public WhileReadBool(WhileBoolVar var) {
        super(var);
    }

    /**
     * The method returns the text representation of the "read" statement for boolean variables.
     * @return the text representation of the "read" statement for boolean variables
     */
    @Override
    public String toString() {
        return "readBool(" + var.toString() + ")";
    }

    /**
     * The method verifies whether another object represents the same While++ "read" statement for boolean variables.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "read" statement for boolean variables
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileReadBool.class) {
            return false;
        }

        WhileReadBool otherReadBool = (WhileReadBool) other;

        return this.var.equals(otherReadBool.var);
    }
}
