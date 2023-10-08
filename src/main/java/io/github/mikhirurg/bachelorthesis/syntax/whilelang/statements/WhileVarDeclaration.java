package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhileVarDeclaration implements WhileStatement {

    private final WhileVar variable;

    private final WhileExpression expression;

    public WhileVarDeclaration(WhileVar variable, WhileExpression expression) {
        this.variable = variable;
        this.expression = expression;
    }

    @Override
    public String textRepresentation() {
        return variable.getType().getName() + " " + variable.getVarName() +
                " := " + expression.textRepresentation();
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
}
