package Problem5BorderControl;

import Problem5BorderControl.contracts.Identifiable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Identifiable> detainedInhabitants = new LinkedList<>();
        List<String> inhabitants = new LinkedList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (!(line = reader.readLine()).equals("End")) {
            inhabitants.add(line.trim());
        }
        String lastDigitsOfFakeIds = reader.readLine().trim();
        for (String inhabitant : inhabitants) {
            String[] currentInhabitantParams = inhabitant.split("\\s+");
            switch (currentInhabitantParams.length) {
                case 2:
                    Identifiable robot = new RobotImpl(currentInhabitantParams[0], currentInhabitantParams[1]);
                    if (!detainedInhabitants.contains(robot)) {
                        if (checkIfFakeId(robot, lastDigitsOfFakeIds)) {
                            detainedInhabitants.add(robot);
                        }
                    }
                    break;
                case 3:
                    Identifiable citizen = new CitizenImpl(currentInhabitantParams[0], Integer.parseInt
                            (currentInhabitantParams[1]),
                            currentInhabitantParams[2]);
                    if (!detainedInhabitants.contains(citizen)) {
                        if (checkIfFakeId(citizen, lastDigitsOfFakeIds)) {
                            detainedInhabitants.add(citizen);
                        }
                    }
                    break;
            }
        }
        for (Identifiable inhabitant : detainedInhabitants) {
            System.out.println(inhabitant);
        }
    }

    private static boolean checkIfFakeId(Identifiable inhabitant, String lastDigitsOfFakeIds) {
        return inhabitant.getId().endsWith(lastDigitsOfFakeIds);
    }
}
