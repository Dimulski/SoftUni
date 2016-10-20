package Problem8Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Car {
    Double speed;
    Double fuel;
    Double fuelEconomy;
    Double distanceTravelled;
    Double timeTravelled;

    public static void main(String[] args) throws IOException { // check my dubs

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carParams = reader.readLine().split(" ");
        Double carSpeed = Double.parseDouble(carParams[0]);
        Double fuel = Double.parseDouble(carParams[1]);
        Double fuelEconomy = Double.parseDouble(carParams[2]);
        Car car = new Car(carSpeed, fuel, fuelEconomy);
        String line;
        while (!(line = reader.readLine()).equals("END")) {
            String[] lineParams = line.split(" ");
            switch (lineParams[0]) {
                case "Travel":
                    car.travel(Double.parseDouble(lineParams[1]));
                    break;
                case "Refuel":
                    car.refuel(Double.parseDouble(lineParams[1]));
                    break;
                case "Distance":
                    car.distance();
                    break;
                case "Time":
                    car.time();
                    break;
                case "Fuel":
                    car.fuel();
                    break;
            }
        }
    }

    Car(Double speed, Double fuel, Double fuelEconomy) {
        this.speed = speed;
        this.fuel = fuel;
        this.fuelEconomy = fuelEconomy;
        this.distanceTravelled = 0d;
        this.timeTravelled = 0d;
    }

    public void travel(Double distance) {
        double canTravelDistance = (this.fuel * 100) / fuelEconomy;
        if (canTravelDistance < distance){
            distance = canTravelDistance;
        }

        double littersAmount = distance * (this.fuelEconomy / 100);
        this.fuel -= littersAmount;
        this.distanceTravelled += distance;
        this.timeTravelled += (distance / this.speed) * 60;
    }

    public void refuel(Double liters) {
        this.fuel += liters;
    }

    public void distance() {
        System.out.println(String.format("Total distance: %.1f kilometers", this.distanceTravelled));
    }

    public void time() {
        Double hours = this.timeTravelled / 60;
        Double minutes = this.timeTravelled - (hours * 60);
        System.out.println(String.format("Total time: %.0f hours and %.0f minutes", hours, minutes));
    }

    public void fuel() {
        System.out.println(String.format("Fuel left: %.1f liters", this.fuel));
    }
}
