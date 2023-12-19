package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

public abstract class WhileRead implements WhileStatement {

    private int id;

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
