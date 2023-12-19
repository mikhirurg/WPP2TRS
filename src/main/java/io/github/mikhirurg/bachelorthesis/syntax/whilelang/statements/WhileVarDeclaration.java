package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhileVarDeclaration implements WhileStatement {

    private final WhileVar variable;

    private final WhileExpression expression;

    private int id = 0;

    public WhileVarDeclaration(WhileVar variable, WhileExpression expression) {
        this.variable = variable;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return variable.getType().getName() + " " + variable.getVarName() +
                " := " + expression.toString();
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitDeclaration(this);
    }

    public WhileVar getVariable() {
        return variable;
    }

    public WhileExpression getExpression() {
        return expression;
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileVarDeclaration.class) {
            return false;
        }

        WhileVarDeclaration otherVarDeclaration = (WhileVarDeclaration) other;

        return this.variable.equals(otherVarDeclaration.variable) && this.expression.equals(otherVarDeclaration.expression);
    }

    @Override
    public int calculateId(int rootId) {
        this.id = rootId;
        return getId();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
