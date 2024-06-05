package io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileString implements WhileStringExpression {
    private final String value;

    public WhileString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "\"" + value + "\"";
    }

    @Override
    public String evaluate(Map<WhileVar, Object> map) {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other.getClass() != WhileString.class) {
            return false;
        }

        WhileString otherString = (WhileString) other;

        return this.value.equals(otherString.value);
    }
}
