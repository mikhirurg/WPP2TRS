package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp.WhileBooleanExpression;

/**
 * WhilePrintBool is a class that represents the While++ print statement for boolean expressions.
 */
public class WhilePrintBool extends WhilePrint {

    /**
     * WhilePrintBool constructor.
     * @param expression boolean expression used in the print statement
     */
    public WhilePrintBool(WhileBooleanExpression expression) {
        super(expression);
    }

    /**
     * The method returns the text representation of the "print" statement for boolean expressions.
     * @return the text representation of the "print" statement for boolean expressions
     */
    @Override
    public String toString() {
        return "printBool(" + expression.toString() + ")";
    }

    /**
     * The method verifies whether another object represents the same While++ "print" statement for boolean expressions.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "print" statement for boolean expressions
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhilePrintBool.class) {
            return false;
        }

        WhilePrintBool otherPrintBool = (WhilePrintBool) other;

        return this.expression.equals(otherPrintBool.expression);
    }
}
