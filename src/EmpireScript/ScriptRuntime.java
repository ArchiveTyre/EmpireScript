package EmpireScript;

import java.util.Stack;

/**
 * @author Tyrerexus
 * @date 7/18/17
 */
public class ScriptRuntime
{
    public WorldInterface worldInterface;


    public InstructionBase[] instructions = null;


    public Stack<ScriptValue> stack = new Stack<>();


    int programCounter = 0;


    public boolean stopped;


    public ScriptRuntime(WorldInterface worldInterface)
    {
        this.worldInterface = worldInterface;
    }


    public void step()
    {
        if (!stopped && instructions != null && programCounter >= 0 && programCounter < instructions.length) {
            instructions[programCounter].execute(this);
            programCounter++;
        }
    }


    public boolean loadScript(String script)
    {
        instructions = new Parser(script).parse();
        return instructions != null;
    }


    public void push(double value)
    {
        stack.add(new ValueNumber(value));
    }


    public void push(String value)
    {
        stack.add(new ValueString(value));
    }
}
