package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhileSkip implements WhileStatement {

    private int id = 0;

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

    @Override
    public int calculateId(int rootId) {
        this.id = rootId;
        return getId();
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
