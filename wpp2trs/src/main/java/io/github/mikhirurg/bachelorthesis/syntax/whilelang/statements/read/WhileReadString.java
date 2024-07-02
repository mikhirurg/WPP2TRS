package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileStringVar;

/**
 * WhileReadString is a class that represents the While++ read statement for string variables.
 */
public class WhileReadString extends WhileRead {

    /**
     * WhileReadString constructor.
     * @param var the string variable used in the read statement
     */
    public WhileReadString(WhileStringVar var) {
        super(var);
    }

    /**
     * The method returns the text representation of the "read" statement for string variables.
     * @return the text representation of the "read" statement for string variables
     */
    @Override
    public String toString() {
        return "readString(" + var.toString() + ")";
    }

    /**
     * The method verifies whether another object represents the same While++ "read" statement for string variables.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "read" statement for string variables
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileReadString.class) {
            return false;
        }

        WhileReadString otherReadString = (WhileReadString) other;

        return this.var.equals(otherReadString.var);
    }
}
