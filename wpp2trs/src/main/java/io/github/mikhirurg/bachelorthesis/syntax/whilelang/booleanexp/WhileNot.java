package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileNot implements WhileBooleanExpression {
    private final WhileBooleanExpression expression;

    public WhileNot(WhileBooleanExpression expression) {
        this.expression = expression;
    }

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
