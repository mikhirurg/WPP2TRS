package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;

public abstract class WhilePrint implements WhileStatement {

    protected final WhileExpression expression;

    public WhilePrint(WhileExpression expression) {
        this.expression = expression;
    }

    public WhileExpression getExpression() {
        return expression;
    }
}
