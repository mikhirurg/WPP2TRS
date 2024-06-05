package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public interface WhileArithmeticExpression extends WhileExpression {
    String toString();

    Integer evaluate(Map<WhileVar, Object> map);

    default WhileType getType() {
        return WhileType.INT;
    }
}
