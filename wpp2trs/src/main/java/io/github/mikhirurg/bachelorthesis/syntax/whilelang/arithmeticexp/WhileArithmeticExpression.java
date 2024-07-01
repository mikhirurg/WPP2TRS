package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileArithmeticExpression is an interface for arithmetic expressions in While++
 */
public interface WhileArithmeticExpression extends WhileExpression {

    /**
     * The method returns the text representation of the arithmetic expression.
     * @return the text representation of the arithmetic expression
     */
    String toString();

    /**
     * The method evaluates the arithmetic expression using the map from variables to integer values.
     * @param map mapping from variables to values
     * @return evaluated value of the arithmetic expression
     */
    Integer evaluate(Map<WhileVar, Object> map);

    /**
     * Returns the type WhileType.INT - the type of the arithmetic expression.
     * @return type of the arithmetic expressions - WhileType.INT
     */
    default WhileType getType() {
        return WhileType.INT;
    }
}
