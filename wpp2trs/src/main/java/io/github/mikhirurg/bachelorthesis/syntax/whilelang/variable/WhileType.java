package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

public enum WhileType {
    INT("Int"), BOOL("Bool"), STRING("String"), UNIT("unit"), LIST("list");

    private final String name;
    WhileType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
