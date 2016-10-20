package Problem2VehiclesExtension.models;

public class Bus extends Vehicle {

    private static Double fuelConsumptionIncrease = 1.4;

    public Bus(Double fuel, Double fuelConsumption, Double tankCapacity) {
        super(fuel, fuelConsumption, fuelConsumptionIncrease, tankCapacity);
    }

    public void travelEmpty(Double distance) {
        this.setFuelConsumptionIncrease(0d);
        super.travel(distance);
        this.setFuelConsumptionIncrease(fuelConsumptionIncrease);
    }
}
