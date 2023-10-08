package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileBooleanExpression;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhileIf implements WhileStatement {

    private final WhileBooleanExpression condition;

    private final WhileStatement statement1;

    private final WhileStatement statement2;

    public WhileIf(WhileBooleanExpression condition, WhileStatement statement1, WhileStatement statement2) {
        this.condition = condition;
        this.statement1 = statement1;
        this.statement2 = statement2;
    }

    public WhileBooleanExpression getCondition() {
        return condition;
    }

    public WhileStatement getStatement1() {
        return statement1;
    }

    public WhileStatement getStatement2() {
        return statement2;
    }

    @Override
    public String textRepresentation() {
        return "if " + condition.textRepresentation() + " then " + statement1.textRepresentation() + " else " + statement2.textRepresentation();
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {

    }

}
