package io.github.mikhirurg.bachelorthesis.syntax.whilelang.arithmeticexp;

/**
 * WhileNumber represents the integer number in While++.
 */
public class WhileNumber {

    /**
     * The integer value of the While++ number.
     */
    private final int value;

    /**
     * WhileNumber constructor.
     * @param number the string representation of the integer number in While++
     */
    public WhileNumber(String number) {
        this.value = Integer.parseInt(number);
    }

    /**
     * The method returns the numerical value of the WhileNumber.
     * @return the numerical value of the WhileNumber
     */
    public int getValue() {
        return value;
    }

    /**
     * The method verifies whether another object represents the same While++ integer number.
     * @param obj another object
     * @return boolean, which describes whether another object is equal to the current While++ integer number
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() != WhileNumber.class) {
            return false;
        }

        WhileNumber other = (WhileNumber) obj;

        return value == other.value;
    }
}
