package EmpireScript;

/**
 * Defines the stop instruction.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionStop extends InstructionBase {
    @Override
    public void execute(ScriptRuntime runtime) {
        runtime.stopped = true;
    }
}
