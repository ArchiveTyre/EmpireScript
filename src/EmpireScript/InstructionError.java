package EmpireScript;

/**
 * Defines the error instruction.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionError extends InstructionBase {
    /**
     * The error message either given through the constructor or the setArgs function.
     */
    private String errorMessage;


    @Override
    void setArgs(String arg) {
        // If we don't already have an error message given to the constructor, we'll use this one. //
        if (errorMessage == null)
            errorMessage = arg;
    }


    @Override
    void execute(ScriptRuntime runtime) {
        reportError(runtime, errorMessage);
    }


    InstructionError(String errorMessage) {
        this.errorMessage = errorMessage;
    }


    InstructionError() {
        this.errorMessage = null;
    }
}
