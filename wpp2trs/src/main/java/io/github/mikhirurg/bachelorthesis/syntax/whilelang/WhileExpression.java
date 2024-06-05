package io.github.mikhirurg.bachelorthesis.syntax.whilelang;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileType;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public interface WhileExpression {
    String toString();

    Object evaluate(Map<WhileVar, Object> map);

    WhileType getType();
}
