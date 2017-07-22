package EmpireScript;

/**
 * Defines the push number instruction.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionNumber extends InstructionBase {
    /**
     * The values to push when this instruction is executed.
     * Null if we fail to parse the arguments.
     */
    private double[] values;


    /**
     * The raw input given by setArgs()
     * Used when reporting errors.
     */
    private String unparsedArgs;


    /**
     * Called when values is null. Will report number format errors if any are found.
     * @param runtime The runtime to which we want to report the error too.
     */
    private void showErrors(ScriptRuntime runtime) {
        String[] args = unparsedArgs.split(" ");
        for (String arg : args) {
            try {
                Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                reportError(runtime, "Number format error: " + arg);
            }
        }
    }


    @Override
    void setArgs(String unparsedArgs) {
        this.unparsedArgs = unparsedArgs;
        String[] args = unparsedArgs.split(" ");
        values = new double[args.length];
        int index = 0;
        for (String arg : args) {
            try {
                values[index] = Double.parseDouble(arg);
            } catch (NumberFormatException e) {
                values = null;
                return;
            }
            index++;
        }
    }


    @Override
    public void execute(ScriptRuntime runtime) {
        if (values != null) {
            for (double value : values) {
                runtime.push(value);
            }
        } else {
            showErrors(runtime);
        }
    }
}
