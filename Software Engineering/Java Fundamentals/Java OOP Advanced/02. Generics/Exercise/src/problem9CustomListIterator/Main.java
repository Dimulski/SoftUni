package problem9CustomListIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        CustomList<String> customList = new CustomList<String>();
        Sorter sorter = new Sorter();
        CommandInterpreter commandInterpreter = new CommandInterpreter(customList, sorter);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while (!(command = reader.readLine()).equals("END")) {
            commandInterpreter.interpretCommand(command);
        }
    }
}
