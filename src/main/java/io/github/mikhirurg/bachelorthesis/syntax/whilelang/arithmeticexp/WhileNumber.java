package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

public class WhileNumber {
    private final int value;

    public WhileNumber(String number) {
        this.value = Integer.parseInt(number);
    }

    public int getValue() {
        return value;
    }
}
