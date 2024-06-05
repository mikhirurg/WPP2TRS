package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileGt implements WhileBooleanExpression {

    private final WhileArithmeticExpression left;

    private final WhileArithmeticExpression right;

    public WhileGt(WhileArithmeticExpression left, WhileArithmeticExpression right) {
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
        return "(" + left.toString() + " > " + right.toString() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (other.getClass() != WhileGt.class) {
            return false;
        }

        WhileGt otherGt = (WhileGt) other;

        return this.left.equals(otherGt.left) && this.right.equals(otherGt.right);
    }
}
