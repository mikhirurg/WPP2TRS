package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileLeq implements WhileBooleanExpression {

    private final WhileArithmeticExpression left;

    private final WhileArithmeticExpression right;

    public WhileLeq(WhileArithmeticExpression left, WhileArithmeticExpression right) {
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
        return "(" + left.toString() + " <= " + right.toString() + ")";
    }

    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return left.evaluate(map) <= right.evaluate(map);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileLeq.class) {
            return false;
        }

        WhileLeq otherLeq = (WhileLeq) other;

        return this.left.equals(otherLeq.left) && this.right.equals(otherLeq.right);
    }
}
