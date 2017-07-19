package EmpireScript;

/**
 * @author Tyrerexus
 * @date 7/19/17
 */
public class ValueArray implements ScriptValue {
    private ScriptValue[] value;

    /**
     * Getter for value.
     *
     * @return The value that this instance represents.
     */
    public ScriptValue[] getValue() {
        return value;
    }


    public ValueArray(int size) {
        value = new ScriptValue[size];
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (ScriptValue value : getValue())
        {
            if (value != null) {
                if (value != getValue()[0])
                    builder.append(',');
                builder.append(value.toString());
            }
        }
        builder.append(']');
        return builder.toString();
    }

    @Override
    public boolean equals(ScriptValue otherValue) {
        if (otherValue instanceof ValueArray) {
            ValueArray otherArray = (ValueArray) otherValue;
            return this.getValue() == otherArray.getValue();
        }
        return false;
    }
}
