package io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileStringExpression is an interface for string expression in While++
 */
public interface WhileStringExpression extends WhileExpression {

    /**
     * The method returns the text representation of the string expression.
     * @param map mapping from variables to values
     * @return the text representation of the string expression
     */
    String evaluate(Map<WhileVar, Object> map);

    /**
     * Returns the type WhileType.STRING - the type of the string expression.
     * @return the type of the string expressions - WhileType.STRING
     */
    @Override
    default WhileType getType() {
        return WhileType.STRING;
    }
}
