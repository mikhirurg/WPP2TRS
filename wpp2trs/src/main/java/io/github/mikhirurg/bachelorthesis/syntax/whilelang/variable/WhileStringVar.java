package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileStringExpression;
import java.util.Map;

/**
 * WhileStringVar is a class that represents the While++ string variable.
 */
public class WhileStringVar extends WhileVar implements WhileStringExpression {

    /**
     * WhileStringVar constructor
     * @param varName the name of the While++ string variable
     */
    public WhileStringVar(String varName) {
        super(varName);
    }

    /**
     * Returns the type <code>WhileType.STRING</code> - the type of the While++ string variable
     * @return the type of the While++ string variable - <code>WhileType.STRING</code>
     */
    @Override
    public WhileType getType() {
        return WhileType.STRING;
    }

    /**
     * The method returns the string representation of the While++ string variable.
     * @return the string representation of the While++ string variable
     */
    @Override
    public String toString() {
        return varName;
    }

    /**
     * The method evaluates the While++ integer variable by returning the string value from the mapping <code>map</code> associated with the current variable.
     * @param map mapping from variables to values
     * @return the string value associated with this variable from the substitution <code>map</code>
     */
    @Override
    public String evaluate(Map<WhileVar, Object> map) {
        return (String) map.get(this);
    }

    /**
     * The method verifies whether another object represents the same While++ string variable.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current string variable.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileStringVar.class) {
            return false;
        }

        WhileStringVar otherLeq = (WhileStringVar) other;

        return this.varName.equals(otherLeq.varName);
    }
}
