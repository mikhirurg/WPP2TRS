package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhilePrintBool extends WhilePrint {
    public WhilePrintBool(WhileExpression expression) {
        super(expression);
    }

    @Override
    public String textRepresentation() {
        return "printBool(" + expression.textRepresentation() + ")";
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {

    }
}
