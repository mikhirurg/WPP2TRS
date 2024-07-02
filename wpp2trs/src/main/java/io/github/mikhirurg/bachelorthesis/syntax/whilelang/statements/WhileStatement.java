package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.SyntaxNode;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

/**
 * WhileStatement is an interface for While++ program statements.
 */
public interface WhileStatement extends SyntaxNode {

    /**
     * The method returns the text representation of the While++ statement.
     * @return the text representation of the While++ statement
     */
    String toString();

    /**
     * The method accepts the TRSPrinter to call the appropriate visit-method for the While++ statement.
     * @param trsPrinter TRSPrinter that is used to create the LCTRS translation
     */
    void acceptTRSPrinter(TRSPrinter trsPrinter);

}
