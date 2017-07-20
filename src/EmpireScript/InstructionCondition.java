package EmpireScript;

/**
 * Defines the condition instruction.
 * This works just like InstructionJump except it only jump if it pops a value and it's value is 1.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionCondition extends InstructionJump {
    @Override
    public void execute(ScriptRuntime runtime) {
        ScriptValue uncheckedValue = runtime.stack.pop();
        if (uncheckedValue instanceof ValueNumber) {
            double value = ((ValueNumber) uncheckedValue).getValue();
            if (value == 1) {
                super.execute(runtime);
            }
        } else {
            reportError(runtime, "Trying to do a conditional number on NON-NUMBER!");
        }
    }
}
