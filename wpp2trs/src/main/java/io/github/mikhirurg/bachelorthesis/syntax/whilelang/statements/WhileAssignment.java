package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

/**
 * WhileAssignment is a class that represents the While++ variable assignment statement.
 */
public class WhileAssignment implements WhileStatement {

    /**
     * The variable used in the assignment statement.
     */
    private final WhileVar variable;

    /**
     * The expression used in the assignment statement.
     */
    private final WhileExpression expression;

    /**
     * WhileAssignment constructor.
     * @param var the variable used in the assignment statement
     * @param expression the expression used in the assignment statement
     */
    public WhileAssignment(WhileVar var, WhileExpression expression) {
        this.variable = var;
        this.expression = expression;
    }

    /**
     * The method returns the variable used in the assignment statement
     * @return the variable used in the assignment statement
     */
    public WhileVar getVariable() {
        return variable;
    }

    /**
     * The method returns the expression used in the assignment statement
     * @return the expression used in the variable assignment statement
     */
    public WhileExpression getExpression() {
        return expression;
    }

    /**
     * The method returns the text representation of the variable assignment statement
     * @return the text representation of the variable assignment
     */
    @Override
    public String toString() {
        return variable.toString() + " := " + expression.toString();
    }

    /**
     * The method accepts the TRSPrinter to call the appropriate visit-method for the variable assignment statement.
     * @param trsPrinter TRSPrinter that is used to create the LCTRS translation
     */
    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitAssignment(this);
    }

    /**
     * The method verifies whether another object represents the same While++ variable assignment statement.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current variable assignment statement.
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileAssignment.class) {
            return false;
        }

        WhileAssignment otherAssignment = (WhileAssignment) other;

        return this.expression.equals(otherAssignment.expression) && this.variable.equals(otherAssignment.variable);
    }

}
