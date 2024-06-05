package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;

public class WhilePrintString extends WhilePrint {

    public WhilePrintString(WhileExpression expression) {
        super(expression);
    }

    @Override
    public String toString() {
        return "printString(" + expression.toString() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhilePrintString.class) {
            return false;
        }

        WhilePrintString otherPrintBool = (WhilePrintString) other;

        return this.expression.equals(otherPrintBool.expression);
    }

}
