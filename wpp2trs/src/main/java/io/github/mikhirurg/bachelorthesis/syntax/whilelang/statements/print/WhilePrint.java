package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.WhileStatement;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

/**
 * WhilePrint is an abstract class for all While++ printing statements
 */
public abstract class WhilePrint implements WhileStatement {

    /**
     * The expression that is used in the While++ "print" statement.
     */
    protected final WhileExpression expression;

    /**
     * WhilePrint constructor.
     * @param expression expression used in the "print" statement
     */
    public WhilePrint(WhileExpression expression) {
        this.expression = expression;
    }

    /**
     * The method returns the expression that is used in the "print" statement.
     * @return the expression used in the "print" statement
     */
    public WhileExpression getExpression() {
        return expression;
    }

    /**
     * The method accepts the TRSPrinter to call the appropriate visit-method for the "print" statement.
     * @param trsPrinter TRSPrinter that is used to create the LCTRS translation
     */
    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitPrint(this);
    }

}
