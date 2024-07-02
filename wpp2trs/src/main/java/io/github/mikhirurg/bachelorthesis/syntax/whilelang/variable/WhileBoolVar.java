package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileBooleanExpression;

import java.util.Map;

/**
 *  WhileBoolVar is a class that represents the While++ boolean variable.
 */
public class WhileBoolVar extends WhileVar implements WhileBooleanExpression {

    /**
     * WhileBoolVar constructor.
     * @param varName the name of the While++ boolean variable
     */
    public WhileBoolVar(String varName) {
        super(varName);
    }

    /**
     * The method returns the string representation of the While++ boolean variable.
     * @return the string representation of the While++ boolean variable
     */
    @Override
    public String toString() {
        return varName;
    }

    /**
     * Returns the type <code>WhileType.BOOL</code> - the type of the While++ boolean variable
     * @return the type of the While++ boolean variable - <code>WhileType.BOOL</code>
     */
    @Override
    public WhileType getType() {
        return WhileType.BOOL;
    }

    /**
     * The method evaluates the While++ boolean variable by returning the boolean value from the mapping <code>map</code> associated with the current variable.
     * @param map mapping from variables to values
     * @return the boolean value associated with this variable from the substitution <code>map</code>
     */
    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return (Boolean) map.get(this);
    }
}
