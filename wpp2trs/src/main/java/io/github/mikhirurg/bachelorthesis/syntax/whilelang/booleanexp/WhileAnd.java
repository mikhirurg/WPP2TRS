package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileAnd implements WhileBooleanExpression {
    private final WhileBooleanExpression left;
    private final WhileBooleanExpression right;

    public WhileAnd(WhileBooleanExpression left, WhileBooleanExpression right) {
        this.left = left;
        this.right = right;
    }

    public WhileBooleanExpression getLeft() {
        return left;
    }

    public WhileBooleanExpression getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " /\\ " + right.toString() + ")";
    }

    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) && right.evaluate(map);
    }

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
