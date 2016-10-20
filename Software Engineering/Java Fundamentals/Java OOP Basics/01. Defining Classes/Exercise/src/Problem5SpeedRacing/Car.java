package Problem5SpeedRacing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Car { // #firstTry

    String model;
    Double fuelAmount;
    Double fuelCostPer1Km;
    Double distanceTravelled;

    Car(String model, Double fuelAmount, Double fuelCostPer1Km) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostPer1Km = fuelCostPer1Km;
        this.distanceTravelled = 0d;
    }

    static Map<String, Car> cars;

    public static void main(String[] args) throws IOException {

        cars = new LinkedHashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] lineParams = reader.readLine().split(" ");
            String model = lineParams[0];
            Double fuelAmount = Double.parseDouble(lineParams[1]);
            Double fuelCostPer1Km = Double.parseDouble(lineParams[2]);

            Car car = new Car(model, fuelAmount, fuelCostPer1Km);

            cars.put(car.model, car);
        }

        StringBuilder sb = new StringBuilder();
        String command;
        while (!(command = reader.readLine()).equals("End")) { // We assume the commands will always be valid.
            String[] commandParams = command.split(" ");
            String model = commandParams[1];
            Double amountOfKm = Double.parseDouble(commandParams[2]);

            boolean drivePossible = cars.get(model).drivePossible(amountOfKm);
            if (drivePossible) {
                cars.get(model).fuelAmount -= amountOfKm * cars.get(model).fuelCostPer1Km;
                cars.get(model).distanceTravelled += amountOfKm;
            } else {
                sb.append(String.format("Insufficient fuel for the drive%s", System.lineSeparator()));
            }
        }
        for (Map.Entry<String, Car> car : cars.entrySet()) {
            sb.append(String.format("%s %.2f %.0f%s", car.getKey(), car.getValue().fuelAmount, car.getValue().distanceTravelled, System.lineSeparator()));
        }
        System.out.println(sb);
    }

    private boolean drivePossible(Double amountOfKm) {
        return fuelAmount - amountOfKm * fuelCostPer1Km >= 0;
    }
}
