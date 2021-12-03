import java.io.*;
import java.util.*;

public class takeInputs {
    public static String startState;
    public static String[] stringsToDetect;
    public static String[][] possibleRoutes;
    public static String[] states;
    public static String[] inputAlphabet;
    public static String[][] possibleStackPushes;
    public static String[][] possibleStackPops;
    public static int numOfGoalStates;
    public static Object[] goalStates;

    public static void takeInputs() throws Exception {
        String inputPath = "C:\\Users\\altug\\Desktop\\Dersler\\CS 410\\Project2\\Input2.txt";

        File file = new File(inputPath);

        Scanner input = new Scanner(file);
        String outputText = "";
        String line1 = input.nextLine();
        int numOfVarsInInputAlphabet = Integer.parseInt(line1);


        String line2 = input.nextLine();
        int numOfVarsInStackAlphabet = Integer.parseInt(line2) + 1;
        String[] stackAlphabet = new String[numOfVarsInStackAlphabet + 1];
        for (int i = numOfVarsInStackAlphabet - 2; i > 0; i--) {
            stackAlphabet[i] = stackAlphabet[i - 1];
        }
        stackAlphabet[0] = "ε";

        String line3 = input.nextLine();
        numOfGoalStates = Integer.parseInt(line3);

        goalStates = new String[numOfGoalStates];


        String line4 = input.nextLine();
        int numOfStates = Integer.parseInt(line4);
        states = new String[numOfStates];

        String line5 = input.nextLine();
        states = line5.split(" ");

        String line6;
        line6 = input.nextLine();
        startState = line6;

        String line7 = input.nextLine();
        goalStates = line7.split(" ");

        String line8 = input.nextLine();
        stackAlphabet = line8.split(" ");

        String line9 = input.nextLine();
        inputAlphabet = new String[numOfVarsInInputAlphabet + 1];
        inputAlphabet[0] = "ε";
        for (int i = 1; i <= line9.split(" ").length; i++) {
            inputAlphabet[i] = line9.split(" ")[i - 1];
        }


        possibleRoutes = new String[numOfStates][numOfVarsInInputAlphabet + 1];
        Arrays.stream(possibleRoutes).forEach(a -> Arrays.fill(a, "null"));

        possibleStackPushes = new String[numOfStates][numOfVarsInInputAlphabet + 1];
        Arrays.stream(possibleStackPushes).forEach(a -> Arrays.fill(a, "null"));

        possibleStackPops = new String[numOfStates][numOfVarsInInputAlphabet + 1];
        Arrays.stream(possibleStackPops).forEach(a -> Arrays.fill(a, "null"));

        String line10 = input.nextLine();
        String line11 = input.nextLine();


        while (input.hasNextLine()) {
            String[] algorithm = line10.split(" ");
            int indexOfState = findIndex.findIndex(states, algorithm[0]);
            int indexOfInputVariable = findIndex.findIndex(inputAlphabet, algorithm[1]);

            possibleStackPops[indexOfState][indexOfInputVariable] = algorithm[2];
            possibleStackPushes[indexOfState][indexOfInputVariable] = algorithm[3];
            possibleRoutes[indexOfState][indexOfInputVariable] = algorithm[4];

            line10 = line11;
            line11 = input.nextLine();
        }
        stringsToDetect = new String[2];
        stringsToDetect[0] = line10;
        stringsToDetect[1] = line11;
    }
}
