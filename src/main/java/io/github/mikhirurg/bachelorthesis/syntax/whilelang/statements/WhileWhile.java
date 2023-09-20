package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileBooleanExpression;

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
    public String textRepresentation() {
        return "while " + condition + " do " + statement;
    }

}
