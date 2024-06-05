package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public abstract class WhileRead implements WhileStatement {

    protected final WhileVar var;

    public WhileRead(WhileVar var) {
        this.var = var;
    }

    public WhileVar getVariable() {
        return var;
    }

    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitRead(this);
    }

}
