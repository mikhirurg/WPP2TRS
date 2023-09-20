package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

public enum WhileVarType {
    INT("int"), BOOL("bool"), STRING("string");

    private final String name;
    private WhileVarType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
