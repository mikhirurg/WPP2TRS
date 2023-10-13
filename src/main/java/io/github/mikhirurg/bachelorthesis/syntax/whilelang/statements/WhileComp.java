package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public class WhileComp implements WhileStatement {

    private final WhileStatement statement1;

    private final WhileStatement statement2;

    public WhileComp(WhileStatement statement1, WhileStatement statement2) {
        this.statement1 = statement1;
        this.statement2 = statement2;
    }

    public WhileStatement getStatement1() {
        return statement1;
    }

    public WhileStatement getStatement2() {
        return statement2;
    }

    @Override
    public String toString() {
        return statement1.toString() + ";\n" + statement2.toString();
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitComp(this);
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileComp.class) {
            return false;
        }

        WhileComp otherComp = (WhileComp) other;

        return this.statement1.equals(otherComp.statement1) && this.statement2.equals(otherComp.statement2);
    }
}
