package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

/**
 * WhileSkip is a class that represents the While++ "skip" statement.
 */
public class WhileSkip implements WhileStatement {

    /**
     * The method returns the text representation of the "skip" statement.
     * @return the text representation of the "skip" statement
     */
    @Override
    public String toString() {
        return "skip";
    }

    /**
     * The method accepts the TRSPrinter to call the appropriate visit-method for the "skip" statement.
     * @param trsPrinter TRSPrinter that is used to create the LCTRS translation
     */
    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitSkip(this);
    }

    /**
     * The method verifies whether another object represents the same While++ "skip" statement.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "skip" statement.
     */
    @Override
    public boolean equals(Object other) {
        return other.getClass() == this.getClass();
    }

}
