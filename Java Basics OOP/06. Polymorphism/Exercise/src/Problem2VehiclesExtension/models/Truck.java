package Problem2VehiclesExtension.models;

public class Truck extends Vehicle {

    private static Double fuelConsumptionIncrease = 1.6;

    public Truck(Double fuel, Double fuelConsumption, Double tankCapacity) {
        super(fuel, fuelConsumption, fuelConsumptionIncrease, tankCapacity);
    }

    @Override
    public void refuel(Double fuel) { // Apparently tank capacity isn't a thing when it comes to trucks. You can fill as much as you want.
        //super.refuel(fuel * 0.95);
        this.setFuel(getFuel() + (fuel * 0.95));
    }
}
