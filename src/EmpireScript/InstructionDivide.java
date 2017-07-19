package EmpireScript;

/**
 * Defines the divide instruction.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionDivide extends InstructionBase {
    @Override
    void execute(ScriptRuntime runtime) {

        // Parse arguments from stack and validate their type. //
        ScriptValue valueA = runtime.stack.pop();
        ScriptValue valueB = runtime.stack.pop();
        if (!(valueA instanceof ValueNumber) || !(valueB instanceof ValueNumber)) {
            runtime.worldInterface.error("Trying to divide NON-NUMBER in divide instruction!");
            return;
        }

        // Do the calculation. //
        double a = ((ValueNumber) valueA).getValue();
        double b = ((ValueNumber) valueB).getValue();
        double result = b / a;

        runtime.push(result);
    }
}