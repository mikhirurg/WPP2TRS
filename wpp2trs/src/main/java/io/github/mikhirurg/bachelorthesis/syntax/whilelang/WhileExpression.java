package io.github.mikhirurg.bachelorthesis.syntax.whilelang;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

/**
 * WhileExpression is an interface for different expressions (arithmetic, boolean, string) in While++
 */
public interface WhileExpression {

    /**
     * The method returns the text representation of the While++ expression
     * @return text representation of the expression
     */
    String toString();

    /**
     * The method evaluates the given expression using the given mapping from variables to values and returns the result
     * @param map mapping from variables to values
     * @return result of expression evaluation using the mapping <code>map</code>
     */
    Object evaluate(Map<WhileVar, Object> map);

    /**
     * The method returns the type of the expression:
     * <ul>
     *     <li> <code>WhileType.INT</code>
     *     <li> <code>WhileType.BOOL</code>
     *     <li> <code>WhileType.STRING</code>
     * </ul>
     * @return type of the expression
     */
    WhileType getType();
}
