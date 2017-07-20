package EmpireScript;

/**
 * @author Tyrerexus
 * @date 7/20/17
 */
public class InstructionReturn extends InstructionBase {
    @Override
    public void execute(ScriptRuntime runtime) {
        runtime.programCounter = runtime.callStack.pop();
    }
}
