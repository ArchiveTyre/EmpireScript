package EmpireScript;

/**
 * As of right now, the only requirement for an EmpireScript value is that it can be compared with other script values.
 * Values should normally be immutable!
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public interface ScriptValue {

    /**
     * Check if the values is equal to another value.
     * Example: if 1 equals 1.
     *
     * @param otherValue The other value to check against.
     * @return True if this and otherValue are equal.
     */
    boolean equals(ScriptValue otherValue);
}
