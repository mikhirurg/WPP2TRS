package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileBooleanExpression;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

/**
 * WhileIf is a class that represents the While++ "if" statement.
 */
public class WhileIf implements WhileStatement {

    /**
     * The condition of the "if" statement.
     */
    private final WhileBooleanExpression condition;

    /**
     * The statement of the first branch of the "if" statement.
     */
    private final WhileStatement statement1;

    /**
     * The statement of the second branch of the "if" statement.
     */
    private final WhileStatement statement2;

    /**
     * WhileIf constructor.
     * @param condition the "if" statement condition
     * @param statement1 the first branch of the "if" statement
     * @param statement2 the second branch of the "if" statement
     */
    public WhileIf(WhileBooleanExpression condition, WhileStatement statement1, WhileStatement statement2) {
        this.condition = condition;
        this.statement1 = statement1;
        this.statement2 = statement2;
    }

    /**
     * The method returns the boolean condition of the "if" statement.
     * @return the boolean condition of the "if" statement.
     */
    public WhileBooleanExpression getCondition() {
        return condition;
    }

    /**
     * The method returns the statement of the first branch of the "if" statement.
     * @return the first branch of the "if" statement
     */
    public WhileStatement getStatement1() {
        return statement1;
    }

    /**
     * The method returns the statement of the second branch of the "if" statement.
     * @return the second branch of the "if" statement
     */
    public WhileStatement getStatement2() {
        return statement2;
    }

    /**
     * The method returns the text representation of the "if" statement
     * @return the text representation of the "if" statement
     */
    @Override
    public String toString() {
        return "if " + condition.toString() + " then (" + statement1.toString() + ") else (" + statement2.toString() + ")";
    }

    /**
     * The method accepts the TRSPrinter to call the appropriate visit-method for the "if" statement.
     * @param trsPrinter TRSPrinter that is used to create the LCTRS translation
     */
    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitIf(this);
    }

    /**
     * The method verifies whether another object represents the same While++ "if" statement.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "if" statement.
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileIf.class) {
            return false;
        }

        WhileIf otherIf = (WhileIf) other;

        return this.condition.equals(otherIf.condition) && this.statement1.equals(otherIf.statement1) && this.statement2.equals(otherIf.statement2);
    }
}
