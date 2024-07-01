package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileMod is a class that represents the While++ modulo arithmetic operation.
 */
public class WhileMod implements WhileArithmeticExpression {

    /**
     * The left operand of the modulo operator.
     */
    private final WhileArithmeticExpression left;

    /**
     * The right operand of the modulo operator.
     */
    private final WhileArithmeticExpression right;

    /**
     * WhileMod constructor.
     * @param left the left operand of the modulo operator
     * @param right the right operand of the modulo operator
     */
    public WhileMod(WhileArithmeticExpression left, WhileArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    /**
     * The method returns the left operand of the modulo operation.
     * @return the left operand of the modulo
     */
    public WhileArithmeticExpression getLeft() {
        return left;
    }

    /**
     * The method returns the right operand of the modulo operation.
     * @return the right operand of the modulo
     */
    public WhileArithmeticExpression getRight() {
        return right;
    }

    /**
     * The method returns the text representation of the modulo operation expression.
     * @return the text representation of the modulo operation
     */
    public String toString() {
        return "(" + left.toString() + " % " + right.toString() + ")";
    }

    /**
     * The method evaluates the modulo operation using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of the modulo operation using the substitution <code>map</code>.
     */
    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) % right.evaluate(map);
    }

    /**
     * The method verifies whether another object represents the same While++ modulo expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current modulo expression
     */
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileMod.class) {
            return false;
        }

        WhileMod otherMod = (WhileMod) other;

        return left.equals(otherMod.left) && right.equals(otherMod.right);
    }


}
