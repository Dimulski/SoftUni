package Problem2VehiclesExtension.models;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private Double fuel;
    private Double fuelConsumption;
    private Double fuelConsumptionIncrease;
    private Double actualFuelConsumption;
    private Double distanceTravelled;
    private Double tankCapacity;

    Vehicle(Double fuel, Double fuelConsumption, Double fuelConsumptionIncrease, Double tankCapacity) {
        this.setFuel(fuel);
        this.setFuelConsumption(fuelConsumption);
        this.setFuelConsumptionIncrease(fuelConsumptionIncrease);
        this.setActualFuelConsumption();
        this.setTankCapacity(tankCapacity);
        this.setDistanceTravelled(0d);
    }

    Double getFuel() {
        return this.fuel;
    }

    void setFuel(Double fuel) {
        this.fuel = fuel;
    }

    private Double getFuelConsumption() {
        return this.fuelConsumption;
    }

    private void setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    private Double getFuelConsumptionIncrease() {
        return this.fuelConsumptionIncrease;
    }

    void setFuelConsumptionIncrease(Double fuelConsumptionIncrease) {
        this.fuelConsumptionIncrease = fuelConsumptionIncrease;
    }

    private Double getActualFuelConsumption() {
        return this.actualFuelConsumption;
    }

    private void setActualFuelConsumption() {
        this.actualFuelConsumption = getFuelConsumption() + getFuelConsumptionIncrease();
    }

    private Double getDistanceTravelled() {
        return this.distanceTravelled;
    } // totally irrelevant. why ask for it.

    private void setDistanceTravelled(Double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    private Double getTankCapacity() {
        return this.tankCapacity;
    }

    private void setTankCapacity(Double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public void refuel(Double fuel) {
        if (this.canRefuel(fuel)) {
            this.fuel += fuel;
        } else {
            this.printUnsuccessfulRefuel();
        }
    }

    private boolean canRefuel(Double fuel) {
        return getTankCapacity() - getFuel() > fuel;
    }

    private void printUnsuccessfulRefuel() {
        System.out.println("Cannot fit fuel in tank");
    }

    public void travel(Double distance) {
        if (this.canTravelDistance(distance)) {
            setFuel(getFuel() - (distance * getActualFuelConsumption()));
            setDistanceTravelled(distance);
            this.printSuccessfulTravel(distance);
        } else {
            this.printUnsuccessfulTravel();
        }
    }

    private boolean canTravelDistance(Double distance) {
        return distance * getActualFuelConsumption() <= getFuel();
    }

    private void printSuccessfulTravel(Double distance) {
        DecimalFormat format = new DecimalFormat("###.######");
        String formatted = format.format(distance);
        System.out.println(String.format("%s travelled %s km", this.getClass().getSimpleName(), formatted));
    }

    private void printUnsuccessfulTravel() {
        System.out.println(String.format("%s needs refueling", this.getClass().getSimpleName()));
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), getFuel());
    }
}
