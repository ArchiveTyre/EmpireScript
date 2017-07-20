package EmpireScript;

/**
 * Defines the store instruction.
 *
 * @author Tyrerexus
 * @date 7/19/17
 */
public class InstructionStore extends InstructionBase {
    @Override
    public void execute(ScriptRuntime runtime) {

        ScriptValue storeValue = runtime.stack.pop();

        ScriptValue indexValue = runtime.stack.pop();

        if (!(indexValue instanceof ValueNumber)) {
            reportError(runtime, "Can't index an array with a NON-NUMBER.");
            return;
        }

        int index = (int) ((ValueNumber) indexValue).getValue();

        ScriptValue arrayValue = runtime.stack.pop();

        if (!(arrayValue instanceof ValueArray)) {
            reportError(runtime, "Can't store value of NON-ARRAY.");
            return;
        }

        ValueArray array = (ValueArray) arrayValue;

        // Pop a value from stack and store it in the array at the index. //
        array.getValue()[index] = storeValue;
    }
}
