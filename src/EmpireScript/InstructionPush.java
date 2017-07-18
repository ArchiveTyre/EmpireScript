package EmpireScript;

/**
 * @author Tyrerexus
 * @date 7/18/17
 */
public class InstructionPush extends InstructionBase {

    private double[] values;
    String unparsedArgs;

    private void showErrors(ScriptRuntime runtime)
    {
        String[] args = unparsedArgs.split(" ");
        for (String arg : args) {
            try {
                Double.parseDouble(arg);
            }
            catch (NumberFormatException e) {
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
            }
            catch (NumberFormatException e) {
                values = null;
                return;
            }
            index++;
        }
    }

    @Override
    void execute(ScriptRuntime runtime) {
        if (values != null) {
            for (double value : values) {
                runtime.push(value);
            }
        }
        else {
            showErrors(runtime);
        }
    }
}
