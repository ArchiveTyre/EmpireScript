package EmpireScript;

/**
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionStop extends InstructionBase {
    @Override
    void execute(ScriptRuntime runtime) {
        runtime.stopped = true;
    }
}
