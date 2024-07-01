package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileBooleanExpression is an interface for boolean expression in While++
 */
public interface WhileBooleanExpression extends WhileExpression {

    /**
     * The method returns the text representation of the boolean expression
     * @return the text representation of the boolean expression
     */
    String toString();

    /**
     * The method evaluates the arithmetic expression using the map from variables to integer values.
     * @param map mapping from variables to values
     * @return evaluated value of the boolean expression
     */
    Boolean evaluate(Map<WhileVar, Object> map);

    /**
     * Returns the type WhileType.BOOL - the type of the boolean expression.
     * @return type of the boolean expressions - WhileType.BOOL
     */
    @Override
    default WhileType getType() {
        return WhileType.BOOL;
    }
}