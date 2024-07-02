package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileLt is a class that represents the While++ "less than" comparison operation.
 */
public class WhileLt implements WhileBooleanExpression {

    /**
     * The left operand of the "less than" comparison operator.
     */
    private final WhileArithmeticExpression left;

    /**
     * The right operand of the "less than" comparison operator.
     */
    private final WhileArithmeticExpression right;

    /**
     * WhileLt constructor.
     * @param left the left operand of the "less than" comparison operator
     * @param right the right operand of the "less than" comparison operator
     */
    public WhileLt(WhileArithmeticExpression left, WhileArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * The method returns the left operand of the "less than" comparison operator.
     * @return the left operand of the "less than" comparison operator
     */
    public WhileArithmeticExpression getLeft() {
        return left;
    }

    /**
     * The method returns the right operand of the "less than" comparison operator.
     * @return the right operand of the "less than" comparison operator
     */
    public WhileArithmeticExpression getRight() {
        return right;
    }

    /**
     * The method evaluates the "less than" comparison operation evaluation using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of the "less than" comparison operation evaluation using the substitution <code>map</code>
     */
    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) < right.evaluate(map);
    }

    /**
     * The method returns the text representation of the "less than" comparison operation expression.
     * @return the text representation of the "less than" comparison operation
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " < " + right.toString() + ")";
    }

    /**
     * The method verifies whether another object represents the same While++ "less than" comparison operation expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "less than" comparison operation expression
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other.getClass() != WhileLt.class) {
            return false;
        }

        WhileLt otherLt = (WhileLt) other;

        return this.left.equals(otherLt.left) && this.right.equals(otherLt.right);
    }
}
