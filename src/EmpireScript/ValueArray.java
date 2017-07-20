package EmpireScript;

import sun.awt.SunHints;

/**
 * @author Tyrerexus
 * @date 7/19/17
 */
public class ValueArray implements ScriptValue {
    public boolean isString;


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
        isString = false;
    }

    public ValueArray(String string)
    {
        value = new ScriptValue[string.length()];

        for (int i = 0; i < string.length(); i++) {
            value[i] = new ValueNumber(string.charAt(i));
        }

        isString = true;
    }

    public ValueArray(ScriptValue[] value)
    {
        this.value = value;
        isString = false;
    }


    @Override
    public String toString() {
        if (isString) {
            StringBuilder builder = new StringBuilder();
            for (ScriptValue value : getValue()) {
                if (value != null) {
                    // Check if normal unicode character.
                    if (value instanceof ValueNumber && Character.isDefined((int) ((ValueNumber) value).getValue())) {
                        builder.appendCodePoint((int) ((ValueNumber) value).getValue());
                    }
                    else {
                        // Just append it normally instead.
                        builder.append(value.toString());
                    }
                }
            }
            return builder.toString();
        }
        else {
            StringBuilder builder = new StringBuilder();
            builder.append('[');
            for (ScriptValue value : getValue()) {
                if (value != null) {
                    if (value != getValue()[0])
                        builder.append(',');
                    builder.append(value.toString());
                }
            }
            builder.append(']');
            return builder.toString();
        }
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
