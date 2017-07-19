package EmpireScript;

/**
 * An interface to the outer world (i.e stuff outside of ScriptRuntime).
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public interface WorldInterface {
    /**
     * Output a message to the world.
     *
     * @param message The message to print
     */
    void print(String message);


    /**
     * Prints an error message to the world.
     *
     * @param errorMessage The message to print
     */
    void error(String errorMessage);


    /**
     * Gets an world variable's value by name.
     *
     * @param variableName The name of the world variable.
     * @return Null on failure. The value on success.
     */
    ScriptValue getVariable(String variableName);


    /**
     * Sets a world variable.
     *
     * @param variableName The name of the world variable.
     * @param value        The new value of the world variable.
     * @return True on success.
     */
    boolean setVariable(String variableName, ScriptValue value);
}
