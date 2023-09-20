package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

public class WhileAnd implements WhileBooleanExpression {
    private final WhileBooleanExpression left;
    private final WhileBooleanExpression right;

    public WhileAnd(WhileBooleanExpression left, WhileBooleanExpression right) {
        this.left = left;
        this.right = right;
    }

    public WhileBooleanExpression getLeft() {
        return left;
    }

    public WhileBooleanExpression getRight() {
        return right;
    }

    @Override
    public String textRepresentation() {
        return "(" + left.textRepresentation() + " ^ " + right.textRepresentation() + ")";
    }

}
