package EmpireScript;

/**
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionError extends InstructionBase
{
    private String errorMessage;


    @Override
    void setArgs(String arg) {
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
