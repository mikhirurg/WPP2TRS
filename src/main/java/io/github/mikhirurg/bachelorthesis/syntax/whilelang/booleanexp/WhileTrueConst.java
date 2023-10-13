package io.github.mikhirurg.bachelorthesis.syntax.whilelang.booleanexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileTrueConst implements WhileBooleanExpression {
    @Override
    public String toString() {
        return "true";
    }

    @Override
    public Boolean evaluate(Map<WhileVar, Object> map) {
        return true;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        return other.getClass() == WhileTrueConst.class;
    }
}
