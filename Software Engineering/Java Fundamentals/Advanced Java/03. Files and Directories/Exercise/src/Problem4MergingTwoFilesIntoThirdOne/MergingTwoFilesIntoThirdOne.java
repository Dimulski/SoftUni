package Problem4MergingTwoFilesIntoThirdOne;

import java.io.*;

/**
 * Created by User on 8.6.2016 г..
 */
public class MergingTwoFilesIntoThirdOne {

    public static void main(String[] args) throws IOException {

        File fileOne = new File("resources\\Problem4MergeFiles\\02_FileOne.txt");
        File fileTwo = new File("resources\\Problem4MergeFiles\\02_FileTwo.txt");
        File merged = new File("resources\\Problem4MergeFiles\\02_Merged.txt");

        try (BufferedReader fileOneReader = new BufferedReader(new FileReader(fileOne));
             BufferedReader fileTwoReader = new BufferedReader(new FileReader(fileTwo));
             BufferedWriter resultWriter = new BufferedWriter(new FileWriter(merged))) {

            while (true){
                String firstInput = fileOneReader.readLine();
                if (firstInput != null){
                    resultWriter.write(firstInput);
                    resultWriter.newLine();
                }
                String secondInput = fileTwoReader.readLine();
                if (secondInput != null){
                    resultWriter.write(secondInput);
                    resultWriter.newLine();
                }
                if (firstInput == null && secondInput == null){
                    break;
                }
            }
        }

    }
}
