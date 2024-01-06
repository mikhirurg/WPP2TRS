package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhileAssignment implements WhileStatement {
    private final WhileVar variable;

    private final WhileExpression expression;

    public WhileAssignment(WhileVar var, WhileExpression expression) {
        this.variable = var;
        this.expression = expression;
    }

    public WhileVar getVariable() {
        return variable;
    }

    public WhileExpression getExpression() {
        return expression;
    }

    @Override
    public String toString() {
        return variable.toString() + " := " + expression.toString();
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitAssignment(this);
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileAssignment.class) {
            return false;
        }

        WhileAssignment otherAssignment = (WhileAssignment) other;

        return this.expression.equals(otherAssignment.expression) && this.variable.equals(otherAssignment.variable);
    }

}
