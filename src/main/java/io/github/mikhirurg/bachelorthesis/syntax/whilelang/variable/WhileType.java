package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

public enum WhileType {
    INT("int"), BOOL("bool"), STRING("string");

    private final String name;
    private WhileType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
