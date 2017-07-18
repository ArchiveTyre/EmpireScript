package EmpireScript;

/**
 * As of right now, the only requirement for an EmpireScript value is that it can be compared with other script values.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public interface ScriptValue {
    boolean equals(ScriptValue otherValue);
}
