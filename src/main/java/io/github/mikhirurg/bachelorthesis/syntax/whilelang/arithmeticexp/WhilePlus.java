package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

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
    public String textRepresentation() {
        return "(" + left.textRepresentation() + " + " + right.textRepresentation() + ")";
    }

}
