package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileDiv is a class that represents the While++ division arithmetic operation.
 */
public class WhileDiv implements WhileArithmeticExpression {

    /**
     * The left operand of the division operator.
     */
    private final WhileArithmeticExpression left;

    /**
     * The right operand of the division operator.
     */
    private final WhileArithmeticExpression right;

    /**
     * WhileDiv constructor.
     * @param left the left operand of the division
     * @param right the right operand of the division
     */
    public WhileDiv(WhileArithmeticExpression left, WhileArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * The method returns the left operand of the division operation.
     * @return the left operand of the division
     */
    public WhileArithmeticExpression getLeft() {
        return left;
    }

    /**
     * The method returns the right operand of the division operation.
     * @return the right operand of the division
     */
    public WhileArithmeticExpression getRight() {
        return right;
    }

    /**
     * The method returns the text representation of the division operation expression.
     * @return the text representation of the division expression
     */
    public String toString() {
        return "(" + left.toString() + " / " + right.toString() + ")";
    }

    /**
     * The method evaluates the integer division using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of integer division operation using substitution <code>map</code>
     */
    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) / right.evaluate(map);
    }

    /**
     * The method verifies whether another object represents the same While++ division expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current division expression
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileDiv.class) {
            return false;
        }

        WhileDiv otherDiv = (WhileDiv) other;

        return left.equals(otherDiv.left) && right.equals(otherDiv.right);
    }

}
