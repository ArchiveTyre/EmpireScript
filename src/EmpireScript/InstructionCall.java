package EmpireScript;

/**
 * Defines the call instruction.
 *
 * @author Tyrerexus
 * @date 7/20/17
 */
public class InstructionCall extends InstructionJump {
    @Override
    public void execute(ScriptRuntime runtime) {
        runtime.callStack.push(lineNumber);
        super.execute(runtime);
    }
}
