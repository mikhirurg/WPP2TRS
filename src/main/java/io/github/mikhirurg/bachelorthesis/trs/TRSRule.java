package io.github.mikhirurg.bachelorthesis.trs;

public class TRSRule {
    private final TRSTerm left;
    private final TRSTerm right;

    private String condition;

    public TRSRule(TRSTerm left, TRSTerm right, String condition) {
        this.left = left;
        this.right = right;
        this.condition = condition;
    }

    public TRSRule(TRSTerm left, TRSTerm right) {
        this(left, right, "true");
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public TRSTerm getLeft() {
        return left;
    }

    public TRSTerm getRight() {
        return right;
    }

    @Override
    public String toString() {
        return left + " -> " + right + "[" + condition + "]";
    }

    public String getCondition() {
        return condition;
    }
}
