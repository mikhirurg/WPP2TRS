package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileOr is a class that represents the While++ logical or operation.
 */
public class WhileOr implements WhileBooleanExpression {

    /**
     * The left operand of the logical or operator.
     */
    private final WhileBooleanExpression left;

    /**
     * The right operand of the logical or operator
     */
    private final WhileBooleanExpression right;

    /**
     * WhileOr constructor.
     * @param left the left operand of the logical or operator
     * @param right the right operand of the logical or operator
     */
    public WhileOr(WhileBooleanExpression left, WhileBooleanExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * The method returns the left operand of the logical or operator
     * @return the left operand of the logical or
     */
    public WhileBooleanExpression getLeft() {
        return left;
    }

    /**
     * The method returns the right operand of the logical or operator
     * @return the right operand of the logical or
     */
    public WhileBooleanExpression getRight() {
        return right;
    }

    /**
     * The method returns the text representation of the logical or operation expression
     * @return the text representation of the logical or operation
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " \\/ " + right.toString() + ")";
    }

    /**
     * The method evaluates the logical or operation using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of the logical or operation evaluation using the substitution <code>map</code>.
     */
    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) || right.evaluate(map);
    }

    /**
     * The method verifies whether another object represents the same While++ logical or operation expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current logical or operation expression
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other.getClass() != WhileOr.class) {
            return false;
        }

        WhileOr otherOr = (WhileOr) other;

        return this.left.equals(otherOr.left) && this.right.equals(otherOr.right);
    }
}
