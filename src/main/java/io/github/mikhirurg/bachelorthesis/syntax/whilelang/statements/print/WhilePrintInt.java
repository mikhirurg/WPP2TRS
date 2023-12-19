package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;

public class WhilePrintInt extends WhilePrint {

    public WhilePrintInt(WhileExpression expression) {
        super(expression);
    }

    @Override
    public String toString() {
        return "printInt(" + expression.toString() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhilePrintInt.class) {
            return false;
        }

        WhilePrintInt otherPrintBool = (WhilePrintInt) other;

        return this.expression.equals(otherPrintBool.expression);
    }

}
