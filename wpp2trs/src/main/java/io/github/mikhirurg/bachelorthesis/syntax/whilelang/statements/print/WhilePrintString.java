package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr.WhileStringExpression;

/**
 * WhilePrintBool is a class that represents the While++ print statement for string expressions.
 */
public class WhilePrintString extends WhilePrint {

    /**
     * WhilePrintString constructor.
     * @param expression string expression used in the print statement
     */
    public WhilePrintString(WhileStringExpression expression) {
        super(expression);
    }

    /**
     * The method returns the text representation of the "print" statement for string expressions.
     * @return the text representation of the "print" statement for string expressions
     */
    @Override
    public String toString() {
        return "printString(" + expression.toString() + ")";
    }

    /**
     * The method verifies whether another object represents the same While++ "print" statement for string expressions.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "print" statement for string expressions
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhilePrintString.class) {
            return false;
        }

        WhilePrintString otherPrintBool = (WhilePrintString) other;

        return this.expression.equals(otherPrintBool.expression);
    }

}
