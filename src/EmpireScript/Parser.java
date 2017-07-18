package EmpireScript;

import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * This class parses EmpireScript script source code into executable instructions.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class Parser
{
    private String[] tokenized;
    int lineNumber = 0;

    Parser(String source)
    {
        tokenized = source.split("\n");
    }

    private InstructionBase instructionFactory(String name)
    {
        // Check if we have a name match. //
        switch (name.toUpperCase()) {
            case "":
                return new InstructionNoop();
            case "ADD":
                return new InstructionAdd();
            case "JUMP":
                return new InstructionJump();
            case "PUSH":
                return new InstructionPush();
            case "STOP":
                return new InstructionStop();
            case "PRINT":
                return new InstructionPrint();
            case "CLONE":
                return new InstructionClone();
            case "LABEL":
                return new InstructionLabel();
            case "ERROR":
                return new InstructionError();
            case "STRING":
                return new InstructionString();
            case "CONCAT":
                return new InstructionConcat();
            case "DIVIDE":
                return new InstructionDivide();
            case "COMPARE":
                return new InstructionCompare();
            case "MULTIPLY":
                return new InstructionMultiply();
            case "SUBTRACT":
                return new InstructionSubtract();
            case "CONDITION":
                return new InstructionCondition();
            default:
                return new InstructionError("Unknown instruction: " + name);

        }
    }

    private InstructionBase parseInstruction(String token) {

        // Parse the token into instruction name and args. //
        //String[] parts = token.split(" ");
        int delim = token.indexOf(' ');
        if (delim < 0)
            delim = token.length();
        String instructionName = token.substring(0, delim);
        String args = delim != 0 && delim != token.length() ? token.substring(delim + 1) : "";

        // Create the instruction from it's name. //
        InstructionBase instructionBase = instructionFactory(instructionName);

        // Set argument and line number and return. //
        instructionBase.lineNumber = lineNumber;
        instructionBase.setArgs(args);
        return instructionBase;
    }

    InstructionBase[] parse() {

        // Allocate the instructions. //
        InstructionBase[] instructions = new InstructionBase[tokenized.length];

        // Iterate each line and parse the instruction on that line. //
        for (String token : tokenized) {
            instructions[lineNumber] = parseInstruction(token);
            lineNumber++;
        }

        // The process is done, return the parsed instructions. //
        return instructions;
    }
}
