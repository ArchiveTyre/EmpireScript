package EmpireScript;

/**
 * Defines the print instruction.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionPrint extends InstructionBase {
    private String suppliedArgument = null;

    @Override
    void setArgs(String args) {
        if (!args.equals("")) {
            suppliedArgument = args;
        }
    }

    @Override
    public void execute(ScriptRuntime runtime) {
        if (suppliedArgument == null) {
            runtime.worldInterface.print(runtime.stack.pop().toString());
        }
        else {
            runtime.worldInterface.print(suppliedArgument);
        }
    }
}
