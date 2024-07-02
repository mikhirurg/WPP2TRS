package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;

/**
 * WhileVar is an abstract class for all While++ variables of different type.
 */
public abstract class WhileVar implements WhileExpression {

    /**
     * The name of the variable.
     */
    protected final String varName;

    /**
     * WhileVar constructor.
     * @param varName the name of the variable
     */
    public WhileVar(String varName) {
        this.varName = varName;
    }

    /**
     * The method verifies whether another object represents the same While++ variable.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current variable.
     */
    @Override
    public boolean equals(Object other) {

        if (other.getClass() != getClass()) {
            return false;
        }

        WhileVar otherVar = (WhileVar) other;
        return varName.equals(otherVar.varName);
    }

    /**
     * The method returns the hash-code of the WhileVar class as a hash-code of the variable's name string representation.
     * @return the hashcode of the WhileVar class
     */
    @Override
    public int hashCode() {
        return varName.hashCode();
    }

    /**
     * The method returns the type of the While++ variable
     * @return the type of the variable
     */
    public WhileType getType() {
        return null;
    }

    /**
     * The method returns the name of the While++ variable
     * @return the name of the While++ variable
     */
    public String getVarName() {
        return varName;
    }

}
