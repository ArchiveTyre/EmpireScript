package EmpireScript;

/**
 * Defines the get instruction.
 *
 * @author Tyrerexus
 * @date 7/19/17
 */
public class InstructionGet extends InstructionBase {
    /**
     * The variable name of the world variable to get.
     */
    private String variableName = null;


    @Override
    void setArgs(String args) {
        variableName = args;
    }


    @Override
    public void execute(ScriptRuntime runtime) {
        runtime.stack.push(runtime.worldInterface.getVariable(variableName));
    }
}
