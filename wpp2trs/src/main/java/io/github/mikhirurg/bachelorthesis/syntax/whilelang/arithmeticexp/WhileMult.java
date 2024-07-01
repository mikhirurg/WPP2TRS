package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileMult is a class that represents the While++ multiplication arithmetic operation.
 */
public class WhileMult implements WhileArithmeticExpression {

    /**
     * The left operand of the multiplication operator.
     */
    private final WhileArithmeticExpression left;

    /**
     * The right operand of the multiplication operator.
     */
    private final WhileArithmeticExpression right;

    /**
     * WhileMult constructor.
     * @param left the left operand of the multiplication
     * @param right the right operand of the multiplication
     */
    public WhileMult(WhileArithmeticExpression left, WhileArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * The method returns the left operand of the multiplication operation.
     * @return the left operand of the multiplication
     */
    public WhileArithmeticExpression getLeft() {
        return left;
    }

    /**
     * The method returns the right operand of the multiplication operation
     * @return the right operand of the multiplication
     */
    public WhileArithmeticExpression getRight() {
        return right;
    }

    /**
     * The method returns the string representation of the multiplication operation expression.
     * @return the string representation of the multiplication expression
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " * " + right.toString() + ")";
    }

    /**
     * The method evaluates the multiplication using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of the multiplication using substitution <code>map</code>
     */
    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) * right.evaluate(map);
    }

    /**
     * The method verifies whether another object represents the same While++ multiplication expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current multiplication expression
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileMult.class) {
            return false;
        }

        WhileMult otherMult = (WhileMult) other;

        return left.equals(otherMult.left) && right.equals(otherMult.right);
    }

}
