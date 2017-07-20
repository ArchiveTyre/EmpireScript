import EmpireScript.InstructionBase;
import EmpireScript.ScriptRuntime;
import EmpireScript.ScriptValue;
import EmpireScript.WorldInterface;

/**
 * @author Tyrerexus
 * @date 7/18/17
 */
public class Tests {

    ScriptRuntime createScript(String source) {
        ScriptRuntime runtime = new ScriptRuntime(new WorldInterface() {
            @Override
            public void print(String message) {
                System.out.println(message);
                System.out.flush();
            }

            @Override
            public void error(String errorMessage) {
                System.out.println(errorMessage);
                System.out.flush();
            }

            @Override
            public ScriptValue getVariable(String variableName) {
                return null;
            }

            @Override
            public boolean setVariable(String variableName, ScriptValue value) {
                return false;
            }

            @Override
            public InstructionBase getCustomInstruction(String name) {
                return null;
            }
        });
        runtime.loadScript(source);
        return runtime;
    }

    void runScript(ScriptRuntime runtime) {
        System.out.println("\n=== BEGIN");
        while (!runtime.stopped)
            runtime.step();
        System.out.println("=== END\n");
    }

    void testAll() {
        createScript("").step();


        runScript(createScript("" +
                "LABEL UNUSED\n" +
                "ERROR Hello World\n" +
                "STOP"));


        runScript(createScript("" +
                "PUSH 1\n" +
                "PUSH 2\n" +
                "ADD\n" +
                "CONCAT 1\n" +
                "PRINT\n" +
                "STOP"));

        runScript(createScript("" +
                "STRING !\n" +
                "STRING Koneko\n" +
                "STRING My name is \n" +
                "CONCAT 3\n" +
                "PRINT\n" +
                "STOP"));

        runScript(createScript("CONCAT 1\nSTOP"));


        runScript(createScript("JUMP UNDEFINED\nSTOP"));


        ScriptRuntime runtime = createScript("" +
                "LABEL LOOP\n" +
                "ERROR Hello World\n" +
                "JUMP LOOP\n" +
                "STOP");
        for (int i = 0; i < 2 * 10 + 1; i++) {
            runtime.step();
        }


        runScript(createScript("" +
                "PUSH 1 2 3\n" +
                "ADD\n" +
                "ADD\n" +
                "CONCAT 1\n" +
                "PRINT\n" +
                "STOP"));


        runScript(createScript("PUSH 1notanumber2\nSTOP"));


        runScript(createScript("" +
                "PUSH 1 2\n" +
                "COMPARE\n" +
                "CONCAT 1\n" +
                "PRINT\n" +
                "STOP"));


        runScript(createScript("" +
                "PUSH 2 2\n" +
                "COMPARE\n" +
                "CONCAT 1\n" +
                "PRINT\n" +
                "STOP"));

        runScript(createScript("" +
                "PUSH 1\n" +
                "CONDITION SKIP\n" +
                "ERROR Conditions don't work!\n" +
                "LABEL SKIP\n" +
                "STOP"));


        runScript(createScript("" +
                "PUSH 10 7\nSUBTRACT\nCONCAT 1\nPRINT\nSTOP"));

        runScript(createScript("" +
                "PUSH 10\nCLONE\nCOMPARE\nCONCAT 1\nPRINT\nSTOP"));


        runScript(createScript("" +
                "PUSH 5\n" +
                "LABEL LOOP\n" +
                "CLONE\n" +
                "PUSH 0\n" +
                "COMPARE\n" +
                "CONDITION EXIT\n" +
                "STRING Hello senpai~~ (^.^)\n" +
                "PRINT\n" +
                "PUSH 1\n" +
                "SUBTRACT\n" +
                "JUMP LOOP\n" +
                "LABEL EXIT\n" +
                "STOP"));
    }

    public static void main(String[] args) {
        new Tests().testAll();
    }
}
