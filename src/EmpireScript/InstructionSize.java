package EmpireScript;

/**
 * Defines the size instruction.
 *
 * @author Tyrerexus
 * @date 7/20/17
 */
public class InstructionSize extends InstructionBase {
    @Override
    public void execute(ScriptRuntime runtime) {
        ScriptValue arrayValue = runtime.stack.pop();

        if (!(arrayValue instanceof ValueArray)) {
            reportError(runtime, "Can't get the size of a NON-ARRAY.");
            return;
        }

        ValueArray array = (ValueArray) arrayValue;

        runtime.push(array.getValue().length);
    }
}
