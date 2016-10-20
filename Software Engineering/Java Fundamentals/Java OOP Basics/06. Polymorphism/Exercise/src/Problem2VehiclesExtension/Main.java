package Problem2VehiclesExtension;

import Problem2VehiclesExtension.models.Car;
import Problem2VehiclesExtension.models.Vehicle;
import Problem2VehiclesExtension.models.Bus;
import Problem2VehiclesExtension.models.Truck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carParams = reader.readLine().split(" ");
        Vehicle car = new Car(Double.parseDouble(carParams[1]), Double.parseDouble(carParams[2]), Double.parseDouble(carParams[3]));
        String[] truckParams = reader.readLine().split(" ");
        Vehicle truck = new Truck(Double.parseDouble(truckParams[1]), Double.parseDouble(truckParams[2]), Double.parseDouble(truckParams[3]));
        String[] busParams = reader.readLine().split(" ");
        Bus bus = new Bus(Double.parseDouble(busParams[1]), Double.parseDouble(busParams[2]), Double.parseDouble(busParams[3]));

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] commandParams = reader.readLine().split(" ");
            switch (commandParams[0]) {
                case "Drive":
                    switch (commandParams[1]) {
                        case "Car":
                            car.travel(Double.parseDouble(commandParams[2]));
                            break;
                        case "Truck":
                            truck.travel(Double.parseDouble(commandParams[2]));
                            break;
                        case "Bus":
                            bus.travel(Double.parseDouble(commandParams[2]));
                    }
                    break;
                case "Refuel":
                    switch (commandParams[1]) {
                        case "Car":
                            car.refuel(Double.parseDouble(commandParams[2]));
                            break;
                        case "Truck":
                            truck.refuel(Double.parseDouble(commandParams[2]));
                            break;
                        case "Bus":
                            bus.refuel(Double.parseDouble(commandParams[2]));
                            break;
                    }
                    break;
                case "DriveEmpty":
                    switch (commandParams[1]) {
                        case "Bus":
                            bus.travelEmpty(Double.parseDouble(commandParams[2]));
                            break;
                    }
                    break;
            }
        }

        System.out.println(car);
        System.out.println(truck);
        System.out.println(bus);
    }
}
