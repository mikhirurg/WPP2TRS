package io.github.mikhirurg.bachelorthesis.syntax.whilelang.stringexpr;

public class WhileString implements WhileStringExpression {
    private final String value;

    public WhileString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String textRepresentation() {
        return "\"" + value + "\"";
    }
}
