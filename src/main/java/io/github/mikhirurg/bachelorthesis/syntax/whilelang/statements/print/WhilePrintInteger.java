package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;

public class WhilePrintInteger extends WhilePrint {
    public WhilePrintInteger(WhileExpression expression) {
        super(expression);
    }

    @Override
    public String toString() {
        return "printInteger(" + expression.toString() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhilePrintInteger.class) {
            return false;
        }

        WhilePrintInteger otherPrintBool = (WhilePrintInteger) other;

        return this.expression.equals(otherPrintBool.expression);
    }
}
