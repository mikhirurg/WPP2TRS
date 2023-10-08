package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhilePrintInteger extends WhilePrint {
    public WhilePrintInteger(WhileExpression expression) {
        super(expression);
    }

    @Override
    public String textRepresentation() {
        return "printInteger(" + expression.textRepresentation() + ")";
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {

    }
}
