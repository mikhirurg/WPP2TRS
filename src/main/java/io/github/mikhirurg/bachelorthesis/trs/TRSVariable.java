package io.github.mikhirurg.bachelorthesis.trs;

public class TRSVariable implements TRSTerm {
    private final String name;

    private String type;

    public TRSVariable(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getType() {
        return type;
    }
}
