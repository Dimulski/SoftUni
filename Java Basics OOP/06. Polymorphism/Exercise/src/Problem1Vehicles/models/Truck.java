package Problem1Vehicles.models;

public class Truck extends Vehicle{

    private static Double fuelConsumptionIncrease = 1.6;

    public Truck(Double fuel, Double fuelConsumption) {
        super(fuel, fuelConsumption, fuelConsumptionIncrease);
    }

    @Override
    public void refuel(Double fuel) {
        super.refuel(fuel * 0.95);
    }
}
