package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

public class WhileNumber {
    private final int value;

    public WhileNumber(String number) {
        this.value = Integer.parseInt(number);
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != WhileNumber.class) {
            return false;
        }

        WhileNumber other = (WhileNumber) obj;

        return value == other.value;
    }
}
