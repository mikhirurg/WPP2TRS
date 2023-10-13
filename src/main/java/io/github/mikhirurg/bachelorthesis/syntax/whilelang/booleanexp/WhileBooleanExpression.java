package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public interface WhileBooleanExpression extends WhileExpression {
    String toString();

    Boolean evaluate(Map<WhileVar, Object> map);
}