package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileBooleanExpression;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

/**
 * WhileWhile is a class that represents the While++ "while" loop statement.
 */
public class WhileWhile implements WhileStatement {

    /**
     * The boolean condition of the "while" loop.
     */
    private final WhileBooleanExpression condition;

    /**
     * The body of the "while" loop.
     */
    private final WhileStatement statement;

    /**
     * WhileWhile constructor.
     * @param condition the condition of the "while" loop.
     * @param statement the body of the "while" loop.
     */
    public WhileWhile(WhileBooleanExpression condition, WhileStatement statement) {
        this.condition = condition;
        this.statement = statement;
    }

    /**
     * The method returns the boolean condition of the "while" loop.
     * @return the boolean condition of the "while" loop
     */
    public WhileBooleanExpression getCondition() {
        return condition;
    }

    /**
     * The method returns the statement that represents the body of the "while" loop.
     * @return the statement that represents the body of the "while" loop
     */
    public WhileStatement getStatement() {
        return statement;
    }

    /**
     * The method returns the text representation of the "while" loop statement.
     * @return the text representation of the "while" loop
     */
    @Override
    public String toString() {
        return "while " + condition + " do (" + statement + ")";
    }

    /**
     * The method accepts the TRSPrinter to call the appropriate visit-method for the "while" loop statement.
     * @param trsPrinter TRSPrinter that is used to create the LCTRS translation
     */
    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitWhile(this);
    }

    /**
     * The method verifies whether another object represents the same While++ "while" loop statement.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "while" loop statement.
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileWhile.class) {
            return false;
        }

        WhileWhile otherWhile = (WhileWhile) other;

        return this.condition.equals(otherWhile.condition) && this.statement.equals(otherWhile.statement);
    }

}
