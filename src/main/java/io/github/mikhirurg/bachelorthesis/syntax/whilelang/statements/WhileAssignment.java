package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileIntVar;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

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
    public String textRepresentation() {
        return variable.textRepresentation() + " := " + expression.textRepresentation();
    }

}
