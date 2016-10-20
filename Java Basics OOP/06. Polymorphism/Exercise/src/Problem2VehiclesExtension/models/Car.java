package Problem2VehiclesExtension.models;

public class Car extends Vehicle {

    private static Double fuelConsumptionIncrease = 0.9;

    public Car(Double fuel, Double fuelConsumption, Double tankCapacity) {
        super(fuel, fuelConsumption, fuelConsumptionIncrease, tankCapacity);
    }
}
