package EmpireScript;

/**
 * Creates another reference to the peek'd value of the runtime stack. Thus "cloning" the value.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionClone extends InstructionBase{

    @Override
    void execute(ScriptRuntime runtime) {
        runtime.stack.push(runtime.stack.peek());
    }
}
