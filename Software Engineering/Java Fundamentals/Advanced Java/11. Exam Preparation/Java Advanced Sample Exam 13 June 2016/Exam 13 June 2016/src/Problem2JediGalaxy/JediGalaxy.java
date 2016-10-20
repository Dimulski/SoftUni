package Problem2JediGalaxy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by User on 16.6.2016 г..
 */
public class JediGalaxy {

    static Long[][] galaxy;
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] galaxyParams = reader.readLine().split(" ");
        Integer rows = Integer.parseInt(galaxyParams[0]);
        Integer cols = Integer.parseInt(galaxyParams[1]);
        galaxy = new Long[rows][cols];
        Long counter = 0L;
        for (int row = 0; row < rows;  row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = counter++;
            }
        }

        String input;
        while(!(input = reader.readLine()).equals("Let the Force be with you")) {
            String[] ivoCoordinates = input.split(" ");
            String[] evilCoordinates = reader.readLine().split(" ");
            boolean isIvoOutOfStarCluster = checkIfOutOfCluster(ivoCoordinates, true);
            boolean isEvilOutOfStarCluster = checkIfOutOfCluster(evilCoordinates, false);
        }

    }

    private static boolean checkIfOutOfCluster(String[] coordinates, boolean isIvo) {
        int row = Integer.parseInt(coordinates[0]);
        int col = Integer.parseInt(coordinates[1]);
        if (isIvo) {
            if (col < galaxy[1].length - 1 ){

            }

        }
        return true;
    }
}
