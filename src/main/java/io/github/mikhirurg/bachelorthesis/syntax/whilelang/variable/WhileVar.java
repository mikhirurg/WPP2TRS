package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.WhileExpression;

public interface WhileVar extends WhileExpression {
    WhileVarType getType();

    String getVarName();
}
