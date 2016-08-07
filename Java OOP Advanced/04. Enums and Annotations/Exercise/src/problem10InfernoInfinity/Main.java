package problem10InfernoInfinity;

import problem10InfernoInfinity.contracts.Database;
import problem10InfernoInfinity.core.DatabaseImpl;
import problem10InfernoInfinity.models.GemFactoryImpl;
import problem10InfernoInfinity.models.WeaponFactoryImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Database db = new DatabaseImpl();

        String[] lineParams;
        while (!((lineParams = reader.readLine().split(";"))[0].equals("END") && lineParams.length == 1)) {
            switch (lineParams[0]) {
                case "Create":
                    db.addWeapon(WeaponFactoryImpl.createWeapon(lineParams[1], lineParams[2]));
                    break;
                case "Add":
                    db.getWeapon(lineParams[1]).addGem(Integer.parseInt(lineParams[2]),
                            GemFactoryImpl.createGem(lineParams[3]));
                    break;
                case "Remove":
                    db.getWeapon(lineParams[1]).removeGem(Integer.parseInt(lineParams[2]));
                    break;
                case "Print":
                    System.out.println(db.getWeapon(lineParams[1]).toString());
            }
        }
    }
}
