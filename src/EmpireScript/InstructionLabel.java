package EmpireScript;

/**
 * Defines the print instruction.
 *
 * A label simply exists to be found by a jump or a call.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionLabel extends InstructionBase {
    /**
     * The name of this label.
     */
    public String name = null;


    @Override
    void setArgs(String arg) {
        name = arg;
    }


    @Override
    void execute(ScriptRuntime runtime) {}
}
