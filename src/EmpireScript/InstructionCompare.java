package EmpireScript;

/**
 * Defines the compare instruction.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionCompare extends InstructionBase {
    @Override
    public void execute(ScriptRuntime runtime) {
        ScriptValue valueA = runtime.stack.pop();
        ScriptValue valueB = runtime.stack.pop();

        if (valueA.getClass() != valueB.getClass()) {
            reportError(runtime, "Trying to compare different types of values!");
        }

        if (valueA.equals(valueB)) {
            runtime.push(1);
        } else {
            runtime.push(0);
        }
    }
}
