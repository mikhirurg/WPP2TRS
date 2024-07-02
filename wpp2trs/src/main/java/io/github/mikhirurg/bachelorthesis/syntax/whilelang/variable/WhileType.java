package io.github.mikhirurg.bachelorthesis.syntax.whilelang.variable;

/**
 * WhileType is an enum class which is used to define types for While++ language constructions.
 */
public enum WhileType {
    INT("Int"), BOOL("Bool"), STRING("String"), UNIT("unit"), LIST("list");

    /**
     * The name used in the LCTRS translation
     */
    private final String name;

    /**
     * WhileType constructor.
     * @param name the type name used in the LCTRS translation
     */
    WhileType(String name) {
        this.name = name;
    }

    /**
     * The method returns the type name used in the LCTRS translation of the type
     * @return the type name used in the LCTRS translation
     */
    public String getName() {
        return name;
    }
}
