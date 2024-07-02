package io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileString represents the string literal in While++.
 */
public class WhileString implements WhileStringExpression {

    /**
     * The string value of the While++ string literal.
     */
    private final String value;

    /**
     * WhileString constructor.
     * @param value the string value of the While++ string literal
     */
    public WhileString(String value) {
        this.value = value;
    }

    /**
     * The method returns the string value of the While++ string literal
     * @return the string value of the While++ string literal
     */
    public String getValue() {
        return value;
    }

    /**
     * The method returns the text representation of the While++ string literal
     * @return the text representation of the While++ string literal
     */
    @Override
    public String toString() {
        return "\"" + value + "\"";
    }

    /**
     * The method returns the string value of the WhileString.
     * @return the string value of the WhileString
     */
    @Override
    public String evaluate(Map<WhileVar, Object> map) {
        return value;
    }

    /**
     * The method verifies whether another object represents the same While++ string literal.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current While++ string literal
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileString.class) {
            return false;
        }

        WhileString otherString = (WhileString) other;

        return this.value.equals(otherString.value);
    }
}
