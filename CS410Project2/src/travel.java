import java.io.*;
import java.util.*;


public class travel {
    public static String outputText;

    public static void travel() {

        Stack stk = new Stack();
        outputText = "";
        boolean atGoal = true;
        for (int i = 0; i < 2; i++) {
            String actualState = takeInputs.startState;
            outputText = outputText + (actualState) + " ";
            for (int j = 0; j < takeInputs.stringsToDetect[i].length(); j++) {
                if (takeInputs.possibleRoutes[findIndex.findIndex(takeInputs.states, actualState)][findIndex.findIndex(takeInputs.inputAlphabet, String.valueOf(takeInputs.stringsToDetect[i].charAt(j)))].equals("null")) {
                    if (takeInputs.possibleStackPushes[findIndex.findIndex(takeInputs.states, actualState)][0].equals("ε")) {
                        if (takeInputs.possibleStackPops[findIndex.findIndex(takeInputs.states, actualState)][0].equals(String.valueOf(stk.peek()))) {
                            j--;
                            actualState = takeInputs.possibleRoutes[findIndex.findIndex(takeInputs.states, actualState)][0];
                            outputText = outputText + (actualState)+ " ";
                            stk.pop();
                        } else {

                            j = takeInputs.stringsToDetect[i].length() + 4;
                            atGoal = false;
                        }

                    } else {
                        stk.push(takeInputs.possibleStackPushes[findIndex.findIndex(takeInputs.states, actualState)][0]);
                        actualState = takeInputs.possibleRoutes[findIndex.findIndex(takeInputs.states, actualState)][0];
                        outputText = outputText + (actualState) + " ";
                        j--;
                    }
                } else {
                    if (takeInputs.possibleStackPushes[findIndex.findIndex(takeInputs.states, actualState)][findIndex.findIndex(takeInputs.inputAlphabet, String.valueOf(takeInputs.stringsToDetect[i].charAt(j)))].equals("ε")) {
                        if (takeInputs.possibleStackPops[findIndex.findIndex(takeInputs.states, actualState)][findIndex.findIndex(takeInputs.inputAlphabet, String.valueOf(takeInputs.stringsToDetect[i].charAt(j)))].equals(String.valueOf(stk.peek()))) {
                            actualState = takeInputs.possibleRoutes[findIndex.findIndex(takeInputs.states, actualState)][findIndex.findIndex(takeInputs.inputAlphabet, String.valueOf(takeInputs.stringsToDetect[i].charAt(j)))];
                            outputText = outputText + (actualState) + " ";
                            stk.pop();
                        } else {
                            atGoal = false;
                            j = takeInputs.stringsToDetect[i].length() + 4;
                        }

                    } else {
                        stk.push(takeInputs.possibleStackPushes[findIndex.findIndex(takeInputs.states, actualState)][findIndex.findIndex(takeInputs.inputAlphabet, String.valueOf(takeInputs.stringsToDetect[i].charAt(j)))]);
                        actualState = takeInputs.possibleRoutes[findIndex.findIndex(takeInputs.states, actualState)][findIndex.findIndex(takeInputs.inputAlphabet, String.valueOf(takeInputs.stringsToDetect[i].charAt(j)))];
                        outputText = outputText + (actualState) + " ";


                    }
                }
            }
            if (atGoal == true) {
                while (!takeInputs.possibleRoutes[findIndex.findIndex(takeInputs.states, actualState)][0].equals("null")) {
                    if (takeInputs.possibleStackPushes[findIndex.findIndex(takeInputs.states, actualState)][0].equals("ε")) {
                        if (takeInputs.possibleStackPops[findIndex.findIndex(takeInputs.states, actualState)][0].equals(String.valueOf(stk.peek()))) {
                            stk.pop();
                        } else {
                            atGoal = false;
                        }
                    } else {
                        stk.push(takeInputs.possibleStackPushes[findIndex.findIndex(takeInputs.states, actualState)][0]);
                    }
                    actualState = takeInputs.possibleRoutes[findIndex.findIndex(takeInputs.states, actualState)][0];
                    outputText = outputText + (actualState) + " ";
                }
            }
            outputText = outputText + "(route taken)\n";
            int isAtFinal = 0;
            if(atGoal) {
                for (int k = 0; k < takeInputs.numOfGoalStates; k++) {
                    if (!actualState.equals(takeInputs.goalStates[k])) {
                        isAtFinal++;
                    }
                }
            }
            if (isAtFinal>0){
                atGoal=true;
            }
            else{
                atGoal = false;
            }
            if(atGoal){
                outputText = outputText + ("Accepted\n");
            }else {
                outputText = outputText + ("Rejected\n");
            }
        }
    }
}