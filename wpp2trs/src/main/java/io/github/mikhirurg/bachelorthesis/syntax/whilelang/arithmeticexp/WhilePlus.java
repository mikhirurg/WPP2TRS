package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhilePlus implements WhileArithmeticExpression {
    private final WhileArithmeticExpression left;
    private final WhileArithmeticExpression right;

    public WhilePlus(WhileArithmeticExpression left, WhileArithmeticExpression right) {
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
        return "(" + left.toString() + " + " + right.toString() + ")";
    }

    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) + right.evaluate(map);
    }


    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhilePlus.class) {
            return false;
        }

        WhilePlus otherPlus = (WhilePlus) other;

        return this.left.equals(otherPlus.left) && this.right.equals(otherPlus.right);
    }
}
