package io.github.mikhirurg.bachelorthesis.trs;

/**
 * TRSVariable is a class that represents the variable used in the LCTRS class representation.
 */
public class TRSVariable implements TRSTerm {

    /**
     * The LCTRS variable name.
     */
    private final String name;

    /**
     * The type of the LCTRS variable.
     */
    private String type;

    /**
     * TRSVariable constructor.
     * @param name the name of the LCTRS variable.
     * @param type the type of the LCTRS variable.
     */
    public TRSVariable(String name, String type) {
        this.name = name;
        this.type = type;
    }

    /**
     * The method returns the name of the LCTRS variable.
     * @return the name of the LCTRS variable
     */
    public String getName() {
        return name;
    }

    /**
     * The method sets the new type for the LCTRS variable.
     * @param type the type of the LCTRS variable
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The method returns the text representation of the LCTRS variable.
     * @return the text representation of the LCTRS variable
     */
    @Override
    public String toString() {
        return name;
    }

    /**
     * The method returns the type of the LCTRS variable.
     * @return the type of the LCTRS variable
     */
    @Override
    public String getType() {
        return type;
    }
}
