package EmpireScript;

/**
 *
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class ValueString implements ScriptValue {
    private String value;


    public String getValue()
    {
        return value;
    }


    public ValueString(String value)
    {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(ScriptValue otherValue) {
        if (otherValue instanceof ValueString) {
            ValueString otherNumber = (ValueString) otherValue;
            return this.getValue().equals(otherNumber.getValue());
        }

        return false;
    }
}
