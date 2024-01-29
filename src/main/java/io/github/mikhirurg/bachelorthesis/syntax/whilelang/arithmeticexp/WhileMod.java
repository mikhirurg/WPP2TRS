package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileMod implements WhileArithmeticExpression {

    private final WhileArithmeticExpression left;

    private final WhileArithmeticExpression right;

    public WhileMod(WhileArithmeticExpression left, WhileArithmeticExpression right) {
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
        return "(" + left.toString() + " % " + right.toString() + ")";
    }

    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) % right.evaluate(map);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileMod.class) {
            return false;
        }

        WhileMod otherMod = (WhileMod) other;

        return left.equals(otherMod.left) && right.equals(otherMod.right);
    }


}
