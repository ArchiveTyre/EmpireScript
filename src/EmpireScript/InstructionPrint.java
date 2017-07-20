package EmpireScript;

/**
 * Defines the print instruction.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionPrint extends InstructionBase {
    @Override
    public void execute(ScriptRuntime runtime) {
        runtime.worldInterface.print(runtime.stack.pop().toString());
    }
}
