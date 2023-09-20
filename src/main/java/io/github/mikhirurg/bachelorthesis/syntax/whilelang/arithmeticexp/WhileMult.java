package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

public class WhileMult implements WhileArithmeticExpression {

    private final WhileArithmeticExpression left;
    private final WhileArithmeticExpression right;

    public WhileMult(WhileArithmeticExpression left, WhileArithmeticExpression right) {
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
        return "(" + left.textRepresentation() + " * " + right.textRepresentation() + ")";
    }

}