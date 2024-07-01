package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileGeq is a class that represents the While++ "greater or equal to" operator
 */
public class WhileGeq implements WhileBooleanExpression {

    /**
     * The left operand of the "greater or equal to" operator.
     */
    private final WhileArithmeticExpression left;

    /**
     * The right operand of the "greater or equal to" operator
     */
    private final WhileArithmeticExpression right;

    /**
     * WhileGeq constructor.
     * @param left the left operand of the "greater or equal to" operator
     * @param right the right operand of the "greater or equal to" operator
     */
    public WhileGeq(WhileArithmeticExpression left, WhileArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * The method returns the left operand of the "greater or equal to" operator.
     * @return the left operand of the "greater or equal to" operator
     */
    public WhileArithmeticExpression getLeft() {
        return left;
    }

    /**
     * The method returns the right operand of the "greater or equal to" operator.
     * @return the right operand of the "greater or equal to" operator
     */
    public WhileArithmeticExpression getRight() {
        return right;
    }

    /**
     * The method evaluates the "greater or equal to" operator using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of the evaluation of the "greater or equal to" operator using the substitution <code>map</code>
     */
    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) >= right.evaluate(map);
    }

    /**
     * The method returns the text representation of the "greater or equal to" operator
     * @return the text representation of the "greater or equal to" operator
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " >= " + right.toString() + ")";
    }

    /**
     * The method verifies whether another object represents the same While++ "greater or equal to" operation expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "greater or equal to" boolean expression
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other.getClass() != WhileGeq.class) {
            return false;
        }

        WhileGeq otherGeq = (WhileGeq) other;

        return this.left.equals(otherGeq.left) && this.right.equals(otherGeq.right);
    }
}
