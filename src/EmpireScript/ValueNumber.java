package EmpireScript;

/**
 * A ScriptValue that represents a number.
 * Must be immutable!
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class ValueNumber implements ScriptValue {

    /**
     * Keep this immutable!
     */
    private double value;


    /**
     * Getter for value.
     *
     * @return The value that this instance represents.
     */
    public double getValue() {
        return value;
    }


    public ValueNumber(double value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public boolean equals(ScriptValue otherValue) {
        if (otherValue instanceof ValueNumber) {
            ValueNumber otherNumber = (ValueNumber) otherValue;
            return this.getValue() == otherNumber.getValue();
        }
        return false;
    }
}
