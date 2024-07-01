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
     * The method returns the
     * @return
     */
    public WhileBooleanExpression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return "not(" + expression.toString() + ")";
    }

    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return !expression.evaluate(map);
    }

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
