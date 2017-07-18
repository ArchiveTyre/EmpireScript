package EmpireScript;

/**
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionPrint extends InstructionBase {

    @Override
    void execute(ScriptRuntime runtime) {
        runtime.worldInterface.print(runtime.stack.pop().toString());
    }
}
