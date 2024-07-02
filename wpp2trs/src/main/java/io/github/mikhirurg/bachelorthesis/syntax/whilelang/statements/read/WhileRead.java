package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.read;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

/**
 * WhileRead is an abstract class for all While++ reading statements
 */
public abstract class WhileRead implements WhileStatement {

    /**
     * The variable used in the read statement.
     */
    protected final WhileVar var;

    /**
     * WhileRead constructor.
     * @param var the variable used in the "read" statement
     */
    public WhileRead(WhileVar var) {
        this.var = var;
    }

    /**
     * The method returns the variable that is used in the "read" statement.
     * @return the expression used in the "read" statement
     */
    public WhileVar getVariable() {
        return var;
    }

    /**
     * The method accepts the TRSPrinter to call the appropriate visit-method for the "read" statement.
     * @param trsPrinter TRSPrinter that is used to create the LCTRS translation
     */
    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitRead(this);
    }

}
