package Problem6BirthdayCelebrations;

import Problem6BirthdayCelebrations.contracts.Birthable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.List;

// Works perfectly with Date and LocalDate except for the last test in Judge
// which REQUIRES birthday to be a String! It DEMANDS you go the lazy way!

public class Main {

    public static void main(String[] args) throws IOException, ParseException {

        List<Birthable> organisms = new LinkedList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] cityMemberParams;
        while (!(cityMemberParams = reader.readLine().split("\\s+"))[0].equals("End")) {
            switch (cityMemberParams[0]) {
                case "Citizen":
                    Birthable citizen = new CitizenImpl(cityMemberParams[1],
                            Integer.parseInt(cityMemberParams[2]),
                            cityMemberParams[3],
                            cityMemberParams[4]);
                    organisms.add(citizen);
                    break;
                case "Pet":
                    Birthable pet = new PetImpl(cityMemberParams[1], cityMemberParams[2]);
                    organisms.add(pet);
                    break;
            }
        }
        String targetYear = reader.readLine();
        organisms.stream().filter(c -> c.getBirthday().endsWith(targetYear)).forEach(c -> System.out.println(c.getBirthday()));
    }
}
