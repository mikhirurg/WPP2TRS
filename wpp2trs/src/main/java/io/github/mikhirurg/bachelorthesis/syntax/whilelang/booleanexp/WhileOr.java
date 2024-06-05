package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileOr implements WhileBooleanExpression {
    private final WhileBooleanExpression left;
    private final WhileBooleanExpression right;

    public WhileOr(WhileBooleanExpression left, WhileBooleanExpression right) {
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
        return "(" + left.toString() + " \\/ " + right.toString() + ")";
    }

    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) || right.evaluate(map);
    }

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
