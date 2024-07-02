package io.github.mikhirurg.bachelorthesis.syntax.whilelang.statements.print;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;

/**
 * WhilePrintInt is a class that represents the While++ print statement for arithmetic expressions.
 */
public class WhilePrintInt extends WhilePrint {

    /**
     * WhilePrintInt constructor.
     * @param expression arithmetic expression used in the print statement
     */
    public WhilePrintInt(WhileArithmeticExpression expression) {
        super(expression);
    }

    /**
     * The method returns the text representation of the "print" statement for arithmetic expressions.
     * @return the text representation of the "print" statement for arithmetic expressions
     */
    @Override
    public String toString() {
        return "printInt(" + expression.toString() + ")";
    }

    /**
     * The method verifies whether another object represents the same While++ "print" statement for arithmetic expressions.
     * @param other another object
     * @return boolean, which describes whether another object is equal to the current "print" statement for arithmetic expressions
     */
    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhilePrintInt.class) {
            return false;
        }

        WhilePrintInt otherPrintBool = (WhilePrintInt) other;

        return this.expression.equals(otherPrintBool.expression);
    }

}
