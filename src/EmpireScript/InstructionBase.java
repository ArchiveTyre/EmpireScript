package EmpireScript;

/**
 * @author Tyrerexus
 * @date 7/18/17
 */
public abstract class InstructionBase {
    /**
     * The line number of the source that this instruction was defined on.
     */
    int lineNumber;


    /**
     * Executes this instruction.
     *
     * @param runtime The runtime that wished for the execution of this instruction.
     */
    public abstract void execute(ScriptRuntime runtime);


    /**
     * Set the argument of this instruction.
     *
     * @param args The argument that this was given to this instruction.
     */
    void setArgs(String args) {
    }


    /**
     * Reports an error that this instruction invoked.
     *
     * @param runtime      The runtime to report the error to.
     * @param errorMessage The error message.
     */
    void reportError(ScriptRuntime runtime, String errorMessage) {
        runtime.worldInterface.error("Error on line " + (lineNumber + 1) + ":\n    " + errorMessage);
    }

}
