package Problem8MilitaryElite;

import Problem8MilitaryElite.contracts.*;
import Problem8MilitaryElite.models.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main { // Hideous...

    public static void main(String[] args) throws IOException { // TODO: Create command interpreter

        Map<Integer, Private> privates = new HashMap<Integer, Private>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] lineParams;
        while (!((lineParams = reader.readLine().split("\\s+"))[0].equals("End") && lineParams.length == 1)) {
            Integer id = Integer.parseInt(lineParams[1]);
            String firstName = lineParams[2];
            String lastName = lineParams[3];
            Double salary = Double.parseDouble(lineParams[4]);
            Corp corp;

            switch (lineParams[0]) {
                case "Private":
                    Private privateInstance = new PrivateImpl(id, firstName, lastName, salary);
                    privates.put(Integer.parseInt(lineParams[1]), privateInstance);
                    System.out.print(privateInstance.toString());
                    break;
                case "Spy":
                    Integer codeNumber;
                    try {
                        codeNumber = Integer.parseInt(lineParams[4]);

                    } catch (IllegalArgumentException e) {
                        continue;
                    }
                    Soldier spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    System.out.print(spy);
                    break;
                case "LeutenantGeneral":
                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    for (int i = 5; i < lineParams.length; i++) {
                        lieutenantGeneral.addPrivate(privates.get(Integer.parseInt(lineParams[i])));
                    }
                    System.out.print(lieutenantGeneral);
                    break;
                case "Engineer":
                    Engineer engineer = null;
                    try {
                        corp = Corp.valueOf(lineParams[5]);
                    } catch (IllegalArgumentException e) {
                        continue;
                    }
                    engineer = new EngineerImpl(id, firstName, lastName, salary, corp);
                    for (int i = 6; i < lineParams.length; i += 2) {
                        Repair repair = new RepairImpl(lineParams[i], Integer.parseInt(lineParams[i + 1]));
                        engineer.addRepair(repair);
                    }
                    System.out.print(engineer.toString());
                    break;
                case "Commando":
                    Commando commando= null;
                    try {
                        corp = Corp.valueOf(lineParams[5]);
                    } catch (IllegalArgumentException e) {
                        continue;
                    }
                    commando = new CommandoImpl(id, firstName, lastName, salary, corp);
                    for (int i = 6; i < lineParams.length; i += 2) {
                        MissionState missionState = null;
                        try {
                            missionState = MissionState.valueOf(lineParams[i + 1]);
                        } catch (IllegalArgumentException e) {
                            continue;
                        }
                        Mission mission = new MissionImpl(lineParams[i], missionState);
                        commando.addMission(mission);
                    }
                    System.out.print(commando);
                    break;
                default:
                    break;
            }
        }
    }
}
