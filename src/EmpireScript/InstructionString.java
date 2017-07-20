package EmpireScript;

/**
 * Defines the string instruction.
 * Will push a string to the runtime stack on execution.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionString extends InstructionBase {
    /**
     * The string that we want to push to the runtime stack on execution.
     * Set by setArgs().
     */
    String string = null;


    @Override
    void setArgs(String arg) {
        string = arg;
    }


    @Override
    public void execute(ScriptRuntime runtime) {
        runtime.push(string);
    }
}
