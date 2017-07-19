import EmpireScript.ScriptRuntime;
import EmpireScript.ScriptValue;
import EmpireScript.WorldInterface;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author Tyrerexus
 * @date 7/18/17
 */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        // For each file name given as arguments. //
        for (String arg : args) {

            // A hash map used to store variables. //
            HashMap<String, ScriptValue> worldVariables = new HashMap<>();

            // Read the contents of the file as source code where arg is the file name. //
            FileInputStream stream = new FileInputStream(arg);
            String source = new Scanner(stream, "UTF-8").useDelimiter("\\A").next();

            // Create the runtime that will run this source code. //
            ScriptRuntime runtime = new ScriptRuntime(new WorldInterface() {
                @Override
                public void print(String message) {
                    System.out.println(message);
                }

                @Override
                public void error(String errorMessage) {
                    System.err.println(errorMessage);
                }

                @Override
                public ScriptValue getVariable(String variableName) {
                    return worldVariables.get(variableName);
                }

                @Override
                public boolean setVariable(String variableName, ScriptValue value) {
                    worldVariables.put(variableName, value);
                    return true;
                }
            });

            // Load the source code into the runtime. //
            runtime.loadScript(source);

            // Run until we stop. //
            while (!runtime.stopped)
                runtime.step();
        }
    }
}
