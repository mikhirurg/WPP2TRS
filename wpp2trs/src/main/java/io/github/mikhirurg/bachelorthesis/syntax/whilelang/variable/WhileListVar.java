package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import java.util.Map;

/**
 * WhileIntVar is a class that represents the While++ list variable
 * (only used as an internal implementation for I/O lists).
 */
public class WhileListVar extends WhileVar {

    /**
     * WhileListVar constructor.
     * @param varName the name of the While++ list variable
     */
    public WhileListVar(String varName) {
        super(varName);
    }

    /**
     * The method verifies whether another object represents the same While++ list variable.
     * @param obj another object
     * @return boolean, which describes whether another object is equal to the current list variable.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof WhileListVar var)) {
            return false;
        }

        return varName.equals(var.varName);
    }

    /**
     * The method returns the string representation of the While++ list variable.
     * @return the string representation of the While++ list variable
     */
    @Override
    public String toString() {
        return varName;
    }

    /**
     * Returns the type <code>WhileType.LIST</code> - the type of the While++ list variable
     * @return the type of the While++ list variable - <code>WhileType.INT</code>
     */
    @Override
    public WhileType getType() {
        return WhileType.LIST;
    }


    /**
     * This method returns null.
     * Because While++ list variables are only used in the internal implementation for I/O lists,
     * there is no way of interacting with these variables in the expressions.
     * Because of it the evaluation implementation is left undefined.
     * @param map mapping from variables to values
     * @return null
     */
    @Override
    public Object evaluate(Map<WhileVar, Object> map) {
        return null;
    }
}
