package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileGt is a class that represents the While++ "greater than" operator.
 */
public class WhileGt implements WhileBooleanExpression {

    /**
     * The left operand of the "greater than" operator.
     */
    private final WhileArithmeticExpression left;

    /**
     * The right operand of the "greater than" operator.
     */
    private final WhileArithmeticExpression right;

    /**
     * WhileGt constructor.
     * @param left the left operand of the "greater than" operator
     * @param right the right operand of the "greater than" operator
     */
    public WhileGt(WhileArithmeticExpression left, WhileArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * The method returns the left operand of the "greater than" operator.
     * @return the left operand of the "greater than" operator
     */
    public WhileArithmeticExpression getLeft() {
        return left;
    }

    /**
     * The method returns the right operand of the modulo operator.
     * @return the right operand of the "greater than" operator
     */
    public WhileArithmeticExpression getRight() {
        return right;
    }

    /**
     * The method evaluates the boolean "greater than" operator using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of the "greater than" operator evaluation using the substitution <code>map</code>
     */
    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) > right.evaluate(map);
    }

    /**
     * The method returns the text representation of the "greater than" operation expression.
     * @return the text representation of the "greater than" operation
     */
    @Override
    public String toString() {
        return "(" + left.toString() + " > " + right.toString() + ")";
    }

    /**
     * The method verifies whether another object represents the same While++ "greater than" expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "greater than" expression
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other.getClass() != WhileGt.class) {
            return false;
        }

        WhileGt otherGt = (WhileGt) other;

        return this.left.equals(otherGt.left) && this.right.equals(otherGt.right);
    }
}
