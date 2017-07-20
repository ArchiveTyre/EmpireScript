package EmpireScript;

import java.util.Arrays;

/**
 * @author Tyrerexus
 * @date 7/20/17
 */
public class InstructionSplit extends InstructionBase {
    @Override
    public void execute(ScriptRuntime runtime) {
        ScriptValue atValue = runtime.stack.pop();

        if (!(atValue instanceof ValueNumber)) {
            reportError(runtime, "Can't split array at NON-NUMBER.");
            return;
        }

        int at = (int) ((ValueNumber) atValue).getValue();

        ScriptValue arrayValue = runtime.stack.pop();

        if (!(arrayValue instanceof ValueArray)) {
            reportError(runtime, "Can't split NON-ARRAY.");
            return;
        }

        ValueArray array = (ValueArray) arrayValue;

        ValueArray partA = new ValueArray(Arrays.copyOfRange(array.getValue(), 0, at));
        partA.isString = array.isString;

        ValueArray partB = new ValueArray(Arrays.copyOfRange(array.getValue(), at, array.getValue().length));
        partB.isString = array.isString;

        runtime.stack.push(partA);
        runtime.stack.push(partB);
    }
}
