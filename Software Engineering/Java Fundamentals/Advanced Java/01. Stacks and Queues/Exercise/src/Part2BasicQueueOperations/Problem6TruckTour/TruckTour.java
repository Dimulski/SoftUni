package Part2BasicQueueOperations.Problem6TruckTour;

import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * Created by User on 23.5.2016 г..
 */
public class TruckTour {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayDeque<Station> queue = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String[] token = scanner.nextLine().split(" ");
            int gas = Integer.parseInt(token[0]);
            int distance = Integer.parseInt(token[1]);
            Station station = new Station();
            station.gasGiven = gas;
            station.distanceToNext = distance;

            queue.addLast(station);
        }

        Integer gasInTank = 0;
        boolean foundFirst = false;
        Integer index = 0;

        while (true) {
            Station currentStation = queue.removeFirst();
            gasInTank += currentStation.gasGiven;
            queue.addLast(currentStation);

            Station firstStation = currentStation;
            Integer indexAddUp = 1;

            while (gasInTank >= currentStation.distanceToNext) {
                gasInTank -= currentStation.distanceToNext;
                currentStation = queue.removeFirst();
                queue.addLast(currentStation);
                gasInTank += currentStation.gasGiven;
                indexAddUp++;

                if (currentStation == firstStation) {
                    foundFirst = true;
                    break;
                }
            }

            if (foundFirst) {
                break;
            }

            index += indexAddUp;
            gasInTank = 0;
        }

        System.out.println(index);
    }
}

 class Station {
     int gasGiven;
     int distanceToNext;
 }
