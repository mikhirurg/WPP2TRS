package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileLt implements WhileBooleanExpression {
    private final WhileArithmeticExpression left;

    private final WhileArithmeticExpression right;

    public WhileLt(WhileArithmeticExpression left, WhileArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    public WhileArithmeticExpression getLeft() {
        return left;
    }

    public WhileArithmeticExpression getRight() {
        return right;
    }

    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) > right.evaluate(map);
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " < " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other.getClass() != WhileLt.class) {
            return false;
        }

        WhileLt otherLt = (WhileLt) other;

        return this.left.equals(otherLt.left) && this.right.equals(otherLt.right);
    }
}
