package EmpireScript;

/**
 * Defines the set instruction.
 *
 * @author Tyrerexus
 * @date 7/19/17
 */
public class InstructionSet extends InstructionBase {
    /**
     * The variable name of the world variable to set.
     */
    private String variableName = null;

    @Override
    void setArgs(String args) {
        variableName = args;
    }

    @Override
    void execute(ScriptRuntime runtime) {
        ScriptValue value = runtime.stack.pop();
        if (!runtime.worldInterface.setVariable(variableName, value)) {
            // If .setVariable returns false, then we must report an error. //
            reportError(runtime, "Couldn't set world variable: \"" + variableName + "\" to: " + value.toString());
        }
    }
}
