package Problem1Vehicles.models;

public class Car extends Vehicle{

    private static Double fuelConsumptionIncrease = 0.9;

    public Car(Double fuel, Double fuelConsumption) {
        super(fuel, fuelConsumption, fuelConsumptionIncrease);
    }
}
