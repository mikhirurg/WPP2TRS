package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable.WhileVar;

import java.util.Map;

public class WhileConst implements WhileArithmeticExpression {
    private final WhileNumber number;

    public WhileConst(String number) {
        this.number = new WhileNumber(number);
    }

    public WhileNumber getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return String.valueOf(number.getValue());
    }

    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return number.getValue();
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != WhileConst.class) {
            return false;
        }

        WhileConst whileConst = (WhileConst) other;

        return this.number.equals(whileConst.number);
    }
}
