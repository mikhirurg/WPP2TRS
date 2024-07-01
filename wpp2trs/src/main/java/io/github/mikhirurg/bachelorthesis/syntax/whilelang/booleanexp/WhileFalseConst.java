package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileFalseConst is a class that represents the While++ "false" boolean constant
 */
public class WhileFalseConst implements WhileBooleanExpression{

    /**
     * The method returns the text representation of the "false" boolean constant
     * @return the text representation of the "false" boolean constant
     */
    @Override
    public String toString() {
        return "false";
    }

    /**
     * The method evaluates the "false" boolean constant, by basically returning the boolean value - false.
     * @param map mapping from variables to values
     * @return the boolean "false" value
     */
    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return false;
    }

    /**
     * The method verifies whether another object represents the same While++ "false" boolean constant.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current false boolean constant
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        return other.getClass() == WhileFalseConst.class;
    }
}
