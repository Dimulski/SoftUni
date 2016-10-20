package Problem10MooD3;

import Problem10MooD3.models.Archangel;
import Problem10MooD3.models.Character;
import Problem10MooD3.models.Demon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] inputParams = reader.readLine().split(" \\| ");
        String username = inputParams[0];
        String characterType = inputParams[1];
        Integer level = Integer.parseInt(inputParams[3]);
        switch (characterType) {
            case "Demon":
                Character demon = new Demon(username, characterType, Double.parseDouble(inputParams[2]), level);
                System.out.println(demon);
                break;
            case "Archangel":
                Character archangel = new Archangel(username, characterType, Integer.parseInt(inputParams[2]), level);
                System.out.println(archangel);
                break;
        }
    }
}
