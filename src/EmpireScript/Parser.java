package EmpireScript;

/**
 * This class parses EmpireScript script source code into executable instructions.
 *
 * @author Tyrerexus
 * @date 7/18/17
 */
public class Parser {

    private final WorldInterface worldInterface;
    /**
     * An array of the source code split by newline.
     */
    private final String[] tokenized;


    /**
     * The current line number being parsed.
     * Starts from zero not one.
     */
    private int lineNumber = 0;

    Parser(WorldInterface worldInterface, String source) {
        tokenized = source.split("\n");
        this.worldInterface = worldInterface;
    }

    /**
     * Creates an instruction by using it's name.
     *
     * @param name The name of the instruction being created.
     * @return The instruction created. InstructionError will be returned on error.
     */
    private InstructionBase instructionFactory(String name) {
        name = name.toUpperCase();

        // Check if we have a name match.                         //
        // If we match default, we'll return an InstructionError. //
        switch (name) {
            case "":
                return new InstructionNoop();
            case "ADD":
                return new InstructionAdd();
            case "GET":
                return new InstructionGet();
            case "SET":
                return new InstructionSet();
            case "JUMP":
                return new InstructionJump();
            case "PUSH":
                return new InstructionPush();
            case "STOP":
                return new InstructionStop();
            case "LOAD":
                return new InstructionLoad();
            case "ARRAY":
                return new InstructionArray();
            case "STORE":
                return new InstructionStore();
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
                InstructionBase instruction = worldInterface.getCustomInstruction(name);
                if (instruction != null) {
                    return instruction;
                }
                else {
                    return new InstructionError("Unknown instruction: " + name);
                }
        }
    }

    /**
     * Tokenizes the line given as argument into both instruction name and instruction arg.
     * It then uses instructionFactory() to create the instruction instance and sets it's lineNumber and arg
     * into the appropriate values.
     *
     * @param tokenLine The line to use for creation of an instruction.
     * @return The instruction created.
     */
    private InstructionBase parseInstruction(String tokenLine) {

        // Parse the token into instruction name and args. //
        int delimiter = tokenLine.indexOf(' ');
        if (delimiter < 0)
            delimiter = tokenLine.length();
        String instructionName = tokenLine.substring(0, delimiter);
        String args = delimiter != 0 && delimiter != tokenLine.length() ? tokenLine.substring(delimiter + 1) : "";

        // Create the instruction from it's name. //
        InstructionBase instructionBase = instructionFactory(instructionName);

        // Set argument and line number and return. //
        instructionBase.lineNumber = lineNumber;
        instructionBase.setArgs(args);
        return instructionBase;
    }

    /**
     * Reads each line of the source code and converts it into a InstructionBase or any of its derivatives.
     *
     * @return A list of instructions that have been created from the source code.
     */
    InstructionBase[] parse() {

        // In case someone calls parse() two times. //
        lineNumber = 0;

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