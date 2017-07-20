package EmpireScript;

/**
 * Defines the print instruction.
 * <p>
 * InstructionJumps attempts to change the program counter of the runtime executing it to that of the referred label.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionJump extends InstructionBase {
    /**
     * The name of the label to jump to.
     */
    public String labelName = null;


    /**
     * The label that we found using it's name.
     */
    private InstructionLabel label = null;


    /**
     * The position that the label is on.
     */
    private int jumpTo = 0;


    /**
     * Find a label based on the name argument in runtime's loaded instructions.
     *
     * @param runtime Where to search for the label.
     * @param name    The label to find by name.
     * @return The found label.
     */
    private InstructionLabel findLabel(ScriptRuntime runtime, String name) {
        for (InstructionBase instructionBase : runtime.instructions) {
            if (instructionBase instanceof InstructionLabel) {
                InstructionLabel label = (InstructionLabel) instructionBase;
                if (label.name.equals(name)) {
                    return label;
                }
            }
        }
        return null;
    }


    @Override
    void setArgs(String arg) {
        labelName = arg;
    }


    @Override
    public void execute(ScriptRuntime runtime) {

        // If the label hasn't been found yet. //
        if (label == null) {

            // Attempt to find it based on args[0]. //
            label = findLabel(runtime, labelName);

            // Check that we actually found it. //
            if (label != null) {
                jumpTo = label.lineNumber;
            } else {
                reportError(runtime, "Couldn't find label: " + labelName);
            }
        }

        // Make the jump. //
        runtime.programCounter = jumpTo;
    }
}
