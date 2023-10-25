package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

public enum WhileType {
    INT("Int"), BOOL("Bool"), STRING("String"), UNIT("unit");

    private final String name;
    private WhileType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
