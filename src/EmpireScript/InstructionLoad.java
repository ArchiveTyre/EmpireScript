package EmpireScript;

/**
 * Defines the load instruction.
 * @author Tyrerexus
 * @date 7/19/17
 */
public class InstructionLoad extends InstructionBase {
    @Override
    void execute(ScriptRuntime runtime) {
        ScriptValue indexValue = runtime.stack.pop();

        if (!(indexValue instanceof ValueNumber)) {
            reportError(runtime, "Can't index an array with a NON-NUMBER.");
            return;
        }

        int index = (int) ((ValueNumber) indexValue).getValue();

        ScriptValue arrayValue = runtime.stack.pop();

        if (!(arrayValue instanceof ValueArray)) {
            reportError(runtime, "Can't load value of NON-ARRAY.");
            return;
        }

        ValueArray array = (ValueArray) arrayValue;

        // Push the value of array at index to stack. //
        runtime.stack.push(array.getValue()[index]);
    }
}
