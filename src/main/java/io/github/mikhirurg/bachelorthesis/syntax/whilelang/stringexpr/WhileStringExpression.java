package io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;
import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public interface WhileStringExpression extends WhileExpression {
    String evaluate(Map<WhileVar, Object> map);
}
