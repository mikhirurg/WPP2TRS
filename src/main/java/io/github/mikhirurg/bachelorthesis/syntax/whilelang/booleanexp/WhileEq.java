package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileEq<T extends WhileExpression> implements WhileBooleanExpression {
    private final T left;
    private final T right;

    public WhileEq(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " = " + right.toString() + ")";
    }

    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map).equals(right.evaluate(map));
    }

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
