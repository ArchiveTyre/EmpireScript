package EmpireScript;

/**
 * @author Tyrerexus
 * @date 7/18/17
 */
public abstract class InstructionBase
{
    int lineNumber;


    void setArgs(String args) {}


    abstract void execute(ScriptRuntime runtime);


    void reportError(ScriptRuntime runtime, String errorMessage)
    {
        runtime.worldInterface.error("Error on line " + (lineNumber + 1) + ":\n    " + errorMessage);
    }

}
