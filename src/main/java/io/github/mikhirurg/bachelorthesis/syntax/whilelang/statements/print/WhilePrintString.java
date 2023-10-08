package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhilePrintString extends WhilePrint {
    public WhilePrintString(WhileExpression expression) {
        super(expression);
    }

    @Override
    public String textRepresentation() {
        return "printString(" + expression.textRepresentation() + ")";
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {

    }
}
