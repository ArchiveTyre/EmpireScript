package EmpireScript;

/**
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionString extends InstructionBase {

    String string = null;


    @Override
    void setArgs(String arg) {
        string = arg;
    }


    @Override
    void execute(ScriptRuntime runtime) {
        runtime.push(string);
    }
}
