package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

public class WhileNot implements WhileBooleanExpression {
    private final WhileBooleanExpression expression;

    public WhileNot(WhileBooleanExpression expression) {
        this.expression = expression;
    }

    public WhileBooleanExpression getExpression() {
        return expression;
    }

    @Override
    public String textRepresentation() {
        return "not(" + expression.textRepresentation() + ")";
    }

}
