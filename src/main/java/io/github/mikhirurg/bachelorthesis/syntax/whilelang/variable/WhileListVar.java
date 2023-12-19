package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import java.util.Map;

public class WhileListVar extends WhileVar {

    public WhileListVar(String varName) {
        super(varName);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof WhileListVar var)) {
            return false;
        }

        return varName.equals(var.varName);
    }

    @Override
    public String toString() {
        return varName;
    }


    @Override
    public WhileType getType() {
        return WhileType.LIST;
    }

    @Override
    public Object evaluate(Map<WhileVar, Object> map) {
        return null;
    }
}
