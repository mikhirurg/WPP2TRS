package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileSub implements WhileArithmeticExpression{
    private final WhileArithmeticExpression left;
    private final WhileArithmeticExpression right;

    public WhileSub(WhileArithmeticExpression left, WhileArithmeticExpression right) {
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
    public String toString() {
        return "(" + left.toString() + " - " + right.toString() + ")";
    }

    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) - right.evaluate(map);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileSub.class) {
            return false;
        }

        WhileSub otherPlus = (WhileSub) other;

        return this.left.equals(otherPlus.left) && this.right.equals(otherPlus.right);
    }
}
