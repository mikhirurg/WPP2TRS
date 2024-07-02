package io.github.mikhirurg.bachelorthesis.trs;

/**
 * TRSRule is a class that represents the LCTRS rule.
 */
public class TRSRule {

    /**
     * The left-hand side of the LCTRS rule.
     */
    private TRSTerm left;

    /**
     * The right-hand side of the LCTRS rule.
     */
    private TRSTerm right;

    /**
     * The boolean constraint of the LCTRS rule.
     */
    private String condition;

    /**
     * TRSRule constructor.
     * @param left the left-hand side of the rule
     * @param right the right-hand side of the rule
     * @param condition the boolean constraint of the LCTRS rule
     */
    public TRSRule(TRSTerm left, TRSTerm right, String condition) {
        this.left = left;
        this.right = right;
        this.condition = condition;
    }

    /**
     * TRSRule constructor for rules with no logical constraints.
     * @param left the left-hand side of the rule
     * @param right the right-hand side of the rule
     */
    public TRSRule(TRSTerm left, TRSTerm right) {
        this(left, right, "true");
    }

    /**
     * The method sets the new boolean constraint for the LCTRS rule
     * @param condition the new LCTRS rule boolean constraint
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * The method sets the new left-hand side for the LCTRS rule.
     * @param left the new left-hand side of the LCTRS rule
     */
    public void setLeft(TRSTerm left) {
        this.left = left;
    }

    /**
     * The method sets the new right-hand side for the LCTRS rule.
     * @param right the new right-hand side of the LCTRS rule
     */
    public void setRight(TRSTerm right) {
        this.right = right;
    }

    /**
     * The method returns the term representing the left-hand side of the LCTRS rule.
     * @return the left-hand side of the LCTRS rule
     */
    public TRSTerm getLeft() {
        return left;
    }

    /**
     * The method returns the term representing the right-hand side of the LCTRS rule.
     * @return the right-hand side of the LCTRS rule
     */
    public TRSTerm getRight() {
        return right;
    }

    /**
     * The method returns the text representation of the LCTRS rule.
     * @return the text representation of the LCTRS rule
     */
    @Override
    public String toString() {
        return left + " -> " + right + " | " + condition;
    }

    /**
     * The method returns the boolean constraint of the LCTRS rule.
     * @return the boolean constraint of the LCTRS rule
     */
    public String getCondition() {
        return condition;
    }
}
