package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileSub is a class that represents the While++ subtraction arithmetic operation.
 */
public class WhileSub implements WhileArithmeticExpression {

    /**
     * The left operand of the subtraction operator.
     */
    private final WhileArithmeticExpression left;

    /**
     * The right operand of the subtraction operator.
     */
    private final WhileArithmeticExpression right;

    /**
     * WhileSub constructor.
     * @param left the left operand of the subtraction
     * @param right the right operand of the subtraction
     */
    public WhileSub(WhileArithmeticExpression left, WhileArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * The method returns the left operand of the subtraction operation.
     * @return the left operand of the subtraction
     */
    public WhileArithmeticExpression getLeft() {
        return left;
    }

    /**
     * The method returns the right operand of the subtraction operation.
     * @return the right operand of the subtraction
     */
    public WhileArithmeticExpression getRight() {
        return right;
    }

    /**
     * The method returns the text representation of the subtraction operation expression.
     * @return the text representation of the subtraction operation
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " - " + right.toString() + ")";
    }

    /**
     * The method evaluates the subtraction using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of subtraction using substitution <code>map</code>
     */
    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) - right.evaluate(map);
    }

    /**
     * The method verifies whether another object represents the same While++ subtraction expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current subtraction expression
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileSub.class) {
            return false;
        }

        WhileSub otherPlus = (WhileSub) other;

        return this.left.equals(otherPlus.left) && this.right.equals(otherPlus.right);
    }
}
