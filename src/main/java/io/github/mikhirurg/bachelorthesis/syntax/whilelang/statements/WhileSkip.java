package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhileSkip implements WhileStatement {

    @Override
    public String textRepresentation() {
        return "skip";
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitSkip(this);
    }

}
