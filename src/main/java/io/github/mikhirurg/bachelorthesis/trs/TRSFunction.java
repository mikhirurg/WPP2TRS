package io.github.mikhirurg.bachelorthesis.trs;

import java.util.ArrayList;
import java.util.List;

public class TRSFunction implements TRSTerm {
    private final String name;

    private final List<TRSTerm> terms;
    private String type;

    public TRSFunction(String name, List<TRSTerm> terms, String type) {
        this.name = name;
        this.terms = new ArrayList<>(terms);
        this.type = type;
    }

    public TRSFunction(String name, List<TRSTerm> terms) {
        this(name, terms, "Unit");
    }

    public String getName() {
        return name;
    }

    public List<TRSTerm> getTerms() {
        return terms;
    }

    public void setType(String type) {
        this.type = type;
    }

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

    @Override
    public String getType() {
        return type;
    }
}
