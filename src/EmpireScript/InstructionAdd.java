package EmpireScript;

/**
 * Defines the add instruction.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionAdd extends InstructionBase {
    @Override
    public void execute(ScriptRuntime runtime) {

        // Parse arguments from stack and validate their type. //
        ScriptValue valueA = runtime.stack.pop();
        ScriptValue valueB = runtime.stack.pop();
        if (!(valueA instanceof ValueNumber) || !(valueB instanceof ValueNumber)) {
            runtime.worldInterface.error("Trying to add NON-NUMBER in add instruction!");
            return;
        }

        // Do the calculation. //
        double a = ((ValueNumber) valueA).getValue();
        double b = ((ValueNumber) valueB).getValue();
        double result = a + b;

        runtime.push(result);
    }
}
