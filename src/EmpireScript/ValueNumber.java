package EmpireScript;

/**
 *
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class ValueNumber implements ScriptValue {
    private double value;


    public double getValue()
    {
        return value;
    }


    public ValueNumber(double value)
    {
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
