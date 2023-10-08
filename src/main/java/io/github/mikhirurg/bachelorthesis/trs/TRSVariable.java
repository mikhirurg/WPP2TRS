package io.github.mikhirurg.bachelorthesis.trs;

public class TRSVariable implements TRSTerm {
    private final String name;

    public TRSVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
