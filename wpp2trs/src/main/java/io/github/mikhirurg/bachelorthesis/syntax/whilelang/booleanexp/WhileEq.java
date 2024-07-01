package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileEq is a generic class that represents the While++ "equal to" operator.
 * @param <T> the type of the operands of the equals operator
 */
public class WhileEq<T extends WhileExpression> implements WhileBooleanExpression {

    /**
     * The left operand of the "equal to" operator.
     */
    private final T left;

    /**
     * The right operand of the "equal to" operator.
     */
    private final T right;

    /**
     * WhileEq constructor.
     * @param left the left operand of the "equal to" operator
     * @param right the right operand of the "equal to" operator
     */
    public WhileEq(T left, T right) {
        this.left = left;
        this.right = right;
    }

    /**
     * The method returns the left operand of the "equal to" operator.
     * @return the left operand of the "equal to" operator
     */
    public T getLeft() {
        return left;
    }

    /**
     * The method returns the right operand of the "equal to" operator.
     * @return the right operand of the "equal to" operator
     */
    public T getRight() {
        return right;
    }

    /**
     * The method returns the text representation of the "equal to" operation.
     * <ul>
     *     <li> For the type <code>WhileType.INT</code> there is used "=" representation
     *     <li> For the type <code>WhileType.BOOL</code> there is used the boolean equivalence formula:
     *     (A /\ B) \/ (not A /\ not B)
     *     <li> Currently "cora" doesn't support the comparison of strings, there is used the "=" representation
     *     for <code>WhileType.STRING</code> type, but it will not work in "cora"
     * </ul>
     * @return the text representation of the "equal to" expression
     */
    @Override
    public String toString() {
        if (left.getType() == WhileType.BOOL) {
            return "((" + left + " /\\ " + right.toString() +
                    ") \\/ (" +
                    "not(" + left + ") /\\ not(" + right +")))";
        }

        return "(" + left + " = " + right.toString() + ")";
    }

    /**
     * The method evaluates the "equals to" operator using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of the evaluation of the "equals to" operator using the substitution <code>map</code>
     */
    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map).equals(right.evaluate(map));
    }

    /**
     * The method verifies whether another object represents the same While++ "equal to" operator.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "equal to" operator
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other.getClass() != WhileEq.class) {
            return false;
        }

        WhileEq otherEq = (WhileEq) other;

        return this.left.equals(otherEq.left) && this.right.equals(otherEq.right);
    }
}
