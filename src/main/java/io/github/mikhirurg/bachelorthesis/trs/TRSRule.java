package io.github.mikhirurg.bachelorthesis.trs;

public class TRSRule {
    private final TRSTerm left;
    private final TRSTerm right;

    private final String condition;

    public TRSRule(TRSTerm left, TRSTerm right, String condition) {
        this.left = left;
        this.right = right;
        this.condition = condition;
    }

    public TRSRule(TRSTerm left, TRSTerm right) {
        this(left, right, "true");
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
