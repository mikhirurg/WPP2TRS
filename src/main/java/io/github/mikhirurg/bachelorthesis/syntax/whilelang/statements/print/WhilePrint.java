package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public abstract class WhilePrint implements WhileStatement {

    private int id = 0;

    protected final WhileExpression expression;

    public WhilePrint(WhileExpression expression) {
        this.expression = expression;
    }

    public WhileExpression getExpression() {
        return expression;
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitPrint(this);
    }

}
