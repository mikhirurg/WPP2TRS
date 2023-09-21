package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

public class WhileStringVar implements WhileVar {

    private final String varName;

    public WhileStringVar(String varName) {
        this.varName = varName;
    }

    @Override
    public WhileType getType() {
        return WhileType.STRING;
    }

    @Override
    public String getVarName() {
        return varName;
    }

    @Override
    public String textRepresentation() {
        return varName;
    }
}
