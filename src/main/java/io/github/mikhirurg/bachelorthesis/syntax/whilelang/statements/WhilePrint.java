package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;

public class WhilePrint implements WhileStatement {

    private final WhileExpression expression;

    public WhilePrint(WhileExpression expression) {
        this.expression = expression;
    }

    @Override
    public String textRepresentation() {
        return "print(" + expression;
    }

    public WhileExpression getExpression() {
        return expression;
    }
}
