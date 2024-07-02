package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileNot is a class that represents the While++ logical negation operation.
 */
public class WhileNot implements WhileBooleanExpression {

    /**
     * The operand of the logical negation.
     */
    private final WhileBooleanExpression expression;

    /**
     * WhileNot constructor.
     * @param expression
     */
    public WhileNot(WhileBooleanExpression expression) {
        this.expression = expression;
    }

    /**
     * The method returns the operand of the logical negation operation.
     * @return the operand of the logical negation operation
     */
    public WhileBooleanExpression getExpression() {
        return expression;
    }

    /**
     * The method returns the text representation of the logical negation operation.
     * @return the text representation of the logical negation operation
     */
    @Override
    public String toString() {
        return "not(" + expression.toString() + ")";
    }

    /**
     * The method evaluates the logical negation using the mapping from variables to values.
     * @param map mapping from variables to values
     * @return the result of the evaluation of the logical negation operation
     */
    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return !expression.evaluate(map);
    }

    /**
     * The method verifies whether another object represents the same While++ negation operation expression.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current logical negation operation expression
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileNot.class) {
            return false;
        }

        WhileNot otherLeq = (WhileNot) other;

        return this.expression.equals(otherLeq.expression);
    }

}
