import EmpireScript.ScriptRuntime;
import EmpireScript.WorldInterface;
import sun.font.Script;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Tyrerexus
 * @date 7/18/17
 */
public class Main
{
    public static void main(String[] args) throws FileNotFoundException {
        for (String arg : args)
        {
            FileInputStream stream = new FileInputStream(arg);
            String source = new Scanner(stream,"UTF-8").useDelimiter("\\A").next();

            ScriptRuntime runtime = new ScriptRuntime(new WorldInterface() {
                @Override
                public void print(String message) {
                    System.out.println(message);
                }

                @Override
                public void error(String errorMessage) {
                    System.err.println(errorMessage);
                }
            });

            runtime.loadScript(source);

            while(!runtime.stopped)
                runtime.step();
        }
    }
}
