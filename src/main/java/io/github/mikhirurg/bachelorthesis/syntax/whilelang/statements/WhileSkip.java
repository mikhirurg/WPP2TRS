package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhileSkip implements WhileStatement {

    @Override
    public String toString() {
        return "skip";
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitSkip(this);
    }

    @Override
    public boolean equals(Object other) {
        return other.getClass() == this.getClass();
    }
}
