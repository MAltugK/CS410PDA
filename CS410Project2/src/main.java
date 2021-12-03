import java.io.*;
import java.util.*;


public class main {
    public static void main(String[] args) throws Exception {

        takeInputs.takeInputs();
        System.out.println();
        travel.travel();





        String outputPath = "C:\\Users\\altug\\Desktop\\Output2.txt";
        try {
            FileWriter myWriter = new FileWriter(outputPath);
            myWriter.write(travel.outputText);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }




}
