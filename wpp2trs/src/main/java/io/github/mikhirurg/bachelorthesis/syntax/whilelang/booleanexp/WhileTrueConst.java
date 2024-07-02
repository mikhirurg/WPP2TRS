package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileTrueConst is a class that represents the While++ "true" boolean constant
 */
public class WhileTrueConst implements WhileBooleanExpression {

    /**
     * The method returns the text representation of the "true" boolean constant
     * @return the text representation of the "true" boolean constant
     */
    @Override
    public String toString() {
        return "true";
    }

    /**
     * The method evaluates the "true" boolean constant, by returning the boolean value - true.
     * @param map mapping from variables to values
     * @return the boolean "true" value
     */
    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return true;
    }

    /**
     * The method verifies whether another object represents the same While++ "true" boolean constant.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "true" boolean constant
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        return other.getClass() == WhileTrueConst.class;
    }
}
