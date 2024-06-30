package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileConst is a class that represents the While++ integer constant.
 */
public class WhileConst implements WhileArithmeticExpression {

    /**
     * The number value of the constant
     */
    private final WhileNumber number;

    /**
     * WhileConst constructor.
     * @param number the string representation of the While++ integer constant
     */
    public WhileConst(String number) {
        this.number = new WhileNumber(number);
    }

    /**
     * The method returns the WhileNumber representation of the While++ constant.
     * @return the WhileNumber representing the While++ constant
     */
    public WhileNumber getNumber() {
        return number;
    }

    /**
     * The method returns the textual representation of the While++ constant.
     * @return the text representation of the integer constant
     */
    @Override
    public String toString() {
        return String.valueOf(number.getValue());
    }

    /**
     * The method returns the value of the constant.
     * @param map mapping from variables to values
     * @return the value of the constant
     */
    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return number.getValue();
    }

    /**
     * The method verifies whether another object represents the same While++ constant.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current constant
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileConst.class) {
            return false;
        }

        WhileConst whileConst = (WhileConst) other;

        return this.number.equals(whileConst.number);
    }
}
