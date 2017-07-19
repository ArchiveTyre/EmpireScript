package EmpireScript;

/**
 * Defines the subtract instruction.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionSubtract extends InstructionBase {
    @Override
    void execute(ScriptRuntime runtime) {

        // Parse arguments from stack and validate their type. //
        ScriptValue valueA = runtime.stack.pop();
        ScriptValue valueB = runtime.stack.pop();
        if (!(valueA instanceof ValueNumber) || !(valueB instanceof ValueNumber)) {
            runtime.worldInterface.error("Trying to subtract NON-NUMBER in subtract instruction!");
            return;
        }

        // Do the calculation. //
        double a = ((ValueNumber) valueB).getValue();
        double b = ((ValueNumber) valueA).getValue();
        double result = a - b;

        runtime.push(result);
    }
}
