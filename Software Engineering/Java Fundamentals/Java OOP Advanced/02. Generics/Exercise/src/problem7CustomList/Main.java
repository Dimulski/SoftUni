package problem7CustomList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        CustomList<String> customList = new CustomList<String>();
        CommandInterpreter commandInterpreter = new CommandInterpreter(customList);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while (!(command = reader.readLine()).equals("END")) {
            commandInterpreter.interpretCommand(command);
        }
    }
}
