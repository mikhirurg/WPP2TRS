package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileLeq is a class that represents the While++ "less than or equal to" comparison operation.
 */
public class WhileLeq implements WhileBooleanExpression {

    /**
     * The left operand of the "less than or equal to" comparison operator.
     */
    private final WhileArithmeticExpression left;

    /**
     * The right operand of the "less than or equal to" comparison operator.
     */
    private final WhileArithmeticExpression right;

    /**
     * WhileLeq constructor.
     * @param left the left operand of the "less than or equal to" comparison operator
     * @param right the right operand of the "less than or equal to" comparison operator
     */
    public WhileLeq(WhileArithmeticExpression left, WhileArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * The method returns the left operand of the "less than or equal to" comparison operator.
     * @return the left operand of the "less than or equal to" operator
     */
    public WhileArithmeticExpression getLeft() {
        return left;
    }

    /**
     * The method returns the right operand of the "less than or equal to" comparison operator.
     * @return the right operand of the "less than or equal to" operator
     */
    public WhileArithmeticExpression getRight() {
        return right;
    }

    /**
     * The method returns the text representation of the "less than or equal to" comparison operation expression.
     * @return the text representation of the "less than or equal to" comparison operation expression
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " <= " + right.toString() + ")";
    }

    /**
     * The method evaluates the "less than or equal to" comparison operator using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of the "less than or equal to" operation evaluation using the substitution <code>map</code>
     */
    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) <= right.evaluate(map);
    }

    /**
     * The method verifies whether another object represents the same While++ "less than or equal to" comparison expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "less than or equal to" comparison operation expression
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileLeq.class) {
            return false;
        }

        WhileLeq otherLeq = (WhileLeq) other;

        return this.left.equals(otherLeq.left) && this.right.equals(otherLeq.right);
    }
}
