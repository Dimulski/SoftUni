package Problem1JediMeditation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

/**
 * Created by User on 16.6.2016 г..
 */
public class JediMeditation {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashSet<String> jediMasters = new LinkedHashSet<>();
        LinkedHashSet<String> jediKnights = new LinkedHashSet<>();
        LinkedHashSet<String> jediPadawans = new LinkedHashSet<>();
        LinkedHashSet<String> jediSlavs = new LinkedHashSet<>();
        boolean masterYodaPresent = false;

        int numberOfLines = Integer.parseInt(reader.readLine());
        for (int i = 0; i < numberOfLines; i++) {
            String[] jediArray = reader.readLine().split(" ");
            for (String jedi : jediArray) {
                switch (jedi.charAt(0)) {
                    case 'm':
                        jediMasters.add(jedi);
                        break;
                    case 'k':
                        jediKnights.add(jedi);
                        break;
                    case 'p':
                        jediPadawans.add(jedi);
                        break;
                    case 't':
                        jediSlavs.add(jedi);
                        break;
                    case 's':
                        jediSlavs.add(jedi);
                        break;
                    case 'y':
                        masterYodaPresent = true;
                        break;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        if (masterYodaPresent) {
            for (String master : jediMasters) {
                stringBuilder.append(master);
                stringBuilder.append(" ");
            }
            for (String knight : jediKnights) {
                stringBuilder.append(knight);
                stringBuilder.append(" ");
            }
            for (String slav : jediSlavs) {
                stringBuilder.append(slav);
                stringBuilder.append(" ");
            }
            for (String padawan : jediPadawans) {
                stringBuilder.append(padawan);
                stringBuilder.append(" ");
            }
        } else {
            for (String slav : jediSlavs) {
                stringBuilder.append(slav);
                stringBuilder.append(" ");
            }
            for (String master : jediMasters) {
                stringBuilder.append(master);
                stringBuilder.append(" ");
            }
            for (String knight : jediKnights) {
                stringBuilder.append(knight);
                stringBuilder.append(" ");
            }
            for (String padawan : jediPadawans) {
                stringBuilder.append(padawan);
                stringBuilder.append(" ");
            }
        }

        System.out.println(stringBuilder);
    }
}
