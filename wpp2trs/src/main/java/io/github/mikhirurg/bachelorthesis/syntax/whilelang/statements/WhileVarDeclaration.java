package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;
import io.github.mikhirurg.bachelorthesis.trs.TRSPrinter;

/**
 * WhileVarDeclaration is a class that represents the While++ variable declaration statement.
 */
public class WhileVarDeclaration implements WhileStatement {

    /**
     * The variable used in the variable declaration statement.
     */
    private final WhileVar variable;

    /**
     * The expression used in the variable declaration statement.
     */
    private final WhileExpression expression;

    /**
     * WhileVarDeclaration constructor.
     * @param variable the variable used in the variable declaration statement
     * @param expression the expression used in the variable declaration statement
     */
    public WhileVarDeclaration(WhileVar variable, WhileExpression expression) {
        this.variable = variable;
        this.expression = expression;
    }

    /**
     * The method returns the text representation of the variable declaration statement
     * @return the text representation of the variable declaration
     */
    @Override
    public String toString() {
        return variable.getType().getName() + " " + variable.getVarName() +
                " := " + expression.toString();
    }

    /**
     * The method accepts the TRSPrinter to call the appropriate visit-method for the variable declaration statement.
     * @param trsPrinter TRSPrinter that is used to create the LCTRS translation
     */
    @Override
    public void acceptTRSPrinter(TRSPrinter trsPrinter) {
        trsPrinter.visitDeclaration(this);
    }

    /**
     * The method returns the variable used in the variable declaration statement.
     * @return the variable used in the variable declaration
     */
    public WhileVar getVariable() {
        return variable;
    }

    /**
     * The method returns the expression used in the variable declaration statement.
     * @return the expression used in the variable declaration statement
     */
    public WhileExpression getExpression() {
        return expression;
    }

    /**
     * The method verifies whether another object represents the same While++ variable declaration statement.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current variable declaration statement.
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileVarDeclaration.class) {
            return false;
        }

        WhileVarDeclaration otherVarDeclaration = (WhileVarDeclaration) other;

        return this.variable.equals(otherVarDeclaration.variable) && this.expression.equals(otherVarDeclaration.expression);
    }

}
