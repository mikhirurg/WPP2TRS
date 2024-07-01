package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhilePlus is a class that represents the While++ addition arithmetic operation.
 */
public class WhilePlus implements WhileArithmeticExpression {

    /**
     * The left operand of the addition operator.
     */
    private final WhileArithmeticExpression left;

    /**
     * The right operand of the addition operator.
     */
    private final WhileArithmeticExpression right;

    /**
     * WhilePlus constructor.
     * @param left the left operand of the addition
     * @param right the right operand of the addition
     */
    public WhilePlus(WhileArithmeticExpression left, WhileArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * Returns the left operand of the addition operation.
     * @return the left operand of the addition
     */
    public WhileArithmeticExpression getLeft() {
        return left;
    }

    /**
     * Returns the right operand the addition operation.
     * @return the right operand of the addition
     */
    public WhileArithmeticExpression getRight() {
        return right;
    }

    /**
     * The method returns the string representation of the addition operation expression.
     * @return the string representation of the addition expression
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " + " + right.toString() + ")";
    }

    /**
     *
     * @param map mapping from variables to values
     * @return the result of addition operation using substitution <code>map</code>
     */
    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) + right.evaluate(map);
    }

    /**
     * The method verifies whether another object represents the same While++ addition expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current addition expression
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhilePlus.class) {
            return false;
        }

        WhilePlus otherPlus = (WhilePlus) other;

        return this.left.equals(otherPlus.left) && this.right.equals(otherPlus.right);
    }
}
