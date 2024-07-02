package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

/**
 * WhileComp is a class that represents the While++ statement composition
 */
public class WhileComp implements WhileStatement {

    /**
     * The first sub-statement used in the statement composition
     */
    private final WhileStatement statement1;

    /**
     * The second sub-statement used in the statement composition
     */
    private final WhileStatement statement2;

    /**
     * WhileComp constructor.
     * @param statement1 the first sub-statement used in the statement composition
     * @param statement2 the second sub-statement used in the statement composition
     */
    public WhileComp(WhileStatement statement1, WhileStatement statement2) {
        this.statement1 = statement1;
        this.statement2 = statement2;
    }

    /**
     * The method returns the first sub-statement of the statement composition
     * @return the first sub-statement of the statement composition
     */
    public WhileStatement getStatement1() {
        return statement1;
    }

    /**
     * The method returns the second sub-statement of the statement composition
     * @return the second sub-statement of the statement composition
     */
    public WhileStatement getStatement2() {
        return statement2;
    }

    /**
     * The method returns the text representation of the statement composition
     * @return the text representation of the statement composition
     */
    @Override
    public String toString() {
        return statement1.toString() + ";\n" + statement2.toString();
    }

    /**
     * The method accepts the TRSPrinter to call the appropriate visit-method for the statement composition.
     * @param trsPrinter TRSPrinter that is used to create the LCTRS translation
     */
    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitComp(this);
    }

    /**
     * The method verifies whether another object represents the same While++ statement composition.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current statement composition.
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileComp.class) {
            return false;
        }

        WhileComp otherComp = (WhileComp) other;

        return this.statement1.equals(otherComp.statement1) && this.statement2.equals(otherComp.statement2);
    }

}
