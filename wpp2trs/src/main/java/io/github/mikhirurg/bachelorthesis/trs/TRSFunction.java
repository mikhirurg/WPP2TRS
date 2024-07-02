package io.github.mikhirurg.bachelorthesis.trs;

import java.util.ArrayList;
import java.util.List;

/**
 * TRSFunction is a class that represents the LCTRS function symbol class representation
 */
public class TRSFunction implements TRSTerm {

    /**
     * The name of the LCTRS function symbol.
     */
    private final String name;

    /**
     * The list of arguments of the LCTRS function symbol.
     */
    private final List<TRSTerm> terms;

    /**
     * The output type of the LCTRS function symbol.
     */
    private String type;

    /**
     * TRSFunction constructor.
     * @param name the LCTRS function symbol name
     * @param terms the list of arguments of the LCTRS function symbol
     * @param type the output type of the LCTRS function symbol
     */
    public TRSFunction(String name, List<TRSTerm> terms, String type) {
        this.name = name;
        this.terms = new ArrayList<>(terms);
        this.type = type;
    }

    /**
     * The method returns the name of the LCTRS function symbol.
     * @return the name of the LCTRS function symbol
     */
    public String getName() {
        return name;
    }

    /**
     * The method returns the list of arguments of the LCTRS function symbol.
     * @return the list of arguments
     */
    public List<TRSTerm> getTerms() {
        return terms;
    }

    /**
     * The method sets the output type of the LCTRS function symbol.
     * @param type the output type of the LCTRS function symbol
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The method returns the text representation of the LCTRS function symbol.
     * @return the text representation of the LCTRS function symbol
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append("(");
        for (TRSTerm trsTerm : terms) {
            builder.append(trsTerm).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append(")");
        return builder.toString();
    }

    /**
     * The method returns the output type of the LCTRS function symbol.
     * @return the output type of the LCTRS function symbol
     */
    @Override
    public String getType() {
        return type;
    }
}
