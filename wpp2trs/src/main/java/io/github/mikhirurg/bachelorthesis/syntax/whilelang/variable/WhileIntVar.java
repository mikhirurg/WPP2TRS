package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

import io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp.WhileArithmeticExpression;

import java.util.Map;

/**
 * WhileIntVar is a class that represents the While++ integer variable.
 */
public class WhileIntVar extends WhileVar implements WhileArithmeticExpression {

    /**
     * WhileIntVar constructor.
     * @param varName the name of the While++ integer variable
     */
    public WhileIntVar(String varName) {
        super(varName);
    }

    /**
     * The method verifies whether another object represents the same While++ integer variable.
     * @param obj another object
     * @return boolean, which describes whether another object is equal to the current integer variable.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof WhileIntVar var)) {
            return false;
        }

        return varName.equals(var.varName);
    }

    /**
     * The method returns the string representation of the While++ integer variable.
     * @return the string representation of the While++ integer variable
     */
    @Override
    public String toString() {
        return varName;
    }

    /**
     * Returns the type <code>WhileType.INT</code> - the type of the While++ integer variable
     * @return the type of the While++ integer variable - <code>WhileType.INT</code>
     */
    @Override
    public WhileType getType() {
        return WhileType.INT;
    }

    /**
     * The method evaluates the While++ integer variable by returning the integer value from the mapping <code>map</code> associated with the current variable.
     * @param map mapping from variables to values
     * @return the integer value associated with this variable from the substitution <code>map</code>
     */
    @Override
    public Integer evaluate(Map<WhileVar, Object> map) {
        return (Integer) map.get(this);
    }
}
