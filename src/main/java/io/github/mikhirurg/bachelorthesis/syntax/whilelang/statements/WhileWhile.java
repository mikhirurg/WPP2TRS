package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileBooleanExpression;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhileWhile implements WhileStatement {

    private final WhileBooleanExpression condition;

    private final WhileStatement statement;

    public WhileWhile(WhileBooleanExpression condition, WhileStatement statement) {
        this.condition = condition;
        this.statement = statement;
    }

    public WhileBooleanExpression getCondition() {
        return condition;
    }

    public WhileStatement getStatement() {
        return statement;
    }

    @Override
    public String toString() {
        return "while " + condition + " do " + statement;
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitWhile(this);
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileWhile.class) {
            return false;
        }

        WhileWhile otherWhile = (WhileWhile) other;

        return this.condition.equals(otherWhile.condition) && this.statement.equals(otherWhile.statement);
    }
}
