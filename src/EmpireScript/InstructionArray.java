package EmpireScript;

/**
 * Defines the array instruction.
 * @author Tyrerexus
 * @date 7/19/17
 */
public class InstructionArray extends InstructionBase {
    @Override
    void execute(ScriptRuntime runtime) {
        ScriptValue valueSize = runtime.stack.pop();

        if (!(valueSize instanceof ValueNumber)) {
            reportError(runtime, "Can't use a NON-NUMBER as the size of a new array.");
            return;
        }

        int size = (int)((ValueNumber) valueSize).getValue();

        runtime.stack.push(new ValueArray(size));
    }
}
