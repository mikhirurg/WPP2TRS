package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileFalseConst implements WhileBooleanExpression{
    @Override
    public String toString() {
        return "false";
    }

    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return false;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        return other.getClass() == WhileFalseConst.class;
    }
}
