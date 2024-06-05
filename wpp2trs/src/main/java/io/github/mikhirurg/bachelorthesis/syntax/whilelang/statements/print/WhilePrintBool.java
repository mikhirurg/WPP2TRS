package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;

public class WhilePrintBool extends WhilePrint {

    public WhilePrintBool(WhileExpression expression) {
        super(expression);
    }

    @Override
    public String toString() {
        return "printBool(" + expression.toString() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhilePrintBool.class) {
            return false;
        }

        WhilePrintBool otherPrintBool = (WhilePrintBool) other;

        return this.expression.equals(otherPrintBool.expression);
    }
}
