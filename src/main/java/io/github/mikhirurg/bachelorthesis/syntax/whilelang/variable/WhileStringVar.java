package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

public class WhileStringVar implements WhileVar {
    @Override
    public WhileVarType getType() {
        return WhileVarType.STRING;
    }

    @Override
    public String textRepresentation() {
        return null;
    }
}
