package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;

public class WhileEq implements WhileBooleanExpression {
    private final WhileArithmeticExpression left;
    private final WhileArithmeticExpression right;

    public WhileEq(WhileArithmeticExpression left, WhileArithmeticExpression right) {
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
    public String textRepresentation() {
        return "(" + left.textRepresentation() + " = " + right.textRepresentation() + ")";
    }

}
