package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileDiv implements WhileArithmeticExpression {

    private final WhileArithmeticExpression left;

    private final WhileArithmeticExpression right;

    public WhileDiv(WhileArithmeticExpression left, WhileArithmeticExpression right) {
        this.left = left;
        this.right = right;
    }

    public WhileArithmeticExpression getLeft() {
        return left;
    }

    public WhileArithmeticExpression getRight() {
        return right;
    }

    public String toString() {
        return "(" + left.toString() + " / " + right.toString() + ")";
    }

    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) / right.evaluate(map);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileDiv.class) {
            return false;
        }

        WhileDiv otherDiv = (WhileDiv) other;

        return left.equals(otherDiv.left) && right.equals(otherDiv.right);
    }

}
