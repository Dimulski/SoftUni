package bg.softuni;

import bg.softuni.io.InputReader;

public class Main {

    public static void main(String[] args) {
        try {
            InputReader.readCommands();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
