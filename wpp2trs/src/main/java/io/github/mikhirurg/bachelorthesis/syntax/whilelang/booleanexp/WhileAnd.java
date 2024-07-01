package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileAnd is a class that represents the While++ boolean "and" operation.
 */
public class WhileAnd implements WhileBooleanExpression {

    /**
     * The left operand of the logical "and" operator.
     */
    private final WhileBooleanExpression left;

    /**
     * The right operand of the logical "and" operator.
     */
    private final WhileBooleanExpression right;

    /**
     * WhileAnd constructor.
     * @param left the left operand of the logical "and"
     * @param right the right operand of the logical "and"
     */
    public WhileAnd(WhileBooleanExpression left, WhileBooleanExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * The method returns the left operand of the logical "and" operator.
     * @return the left operand of the logical "and"
     */
    public WhileBooleanExpression getLeft() {
        return left;
    }

    /**
     * The method returns the right operand of the logical "and" operator.
     * @return the right operand of the logical "and"
     */
    public WhileBooleanExpression getRight() {
        return right;
    }

    /**
     * The method returns the text representation of the logical "and" expression.
     * @return the text representation of the logical "and" expression
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " /\\ " + right.toString() + ")";
    }

    /**
     * The method evaluates the logical "and" operation using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of evaluation of the logical "and" operation using substitution <code>map</code>
     */
    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) && right.evaluate(map);
    }

    /**
     * The method verifies whether another object represents the same While++ logical "and" expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current logical "and" expression
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other.getClass() != WhileAnd.class) {
            return false;
        }

        WhileAnd otherAnd = (WhileAnd) other;

        return this.left.equals(otherAnd.left) && this.right.equals(otherAnd.right);
    }
}
