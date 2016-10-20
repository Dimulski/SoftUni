package Problem1Vehicles.models;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private Double fuel;
    private Double fuelConsumption;
    private Double fuelConsumptionIncrease;
    private Double fuelConsumptionDuringSummer;
    private Double distanceTravelled;

    Vehicle(Double fuel, Double fuelConsumption, Double fuelConsumptionIncrease) {
        this.setFuel(fuel);
        this.setFuelConsumption(fuelConsumption);
        this.setFuelConsumptionIncrease(fuelConsumptionIncrease);
        this.setFuelConsumptionDuringSummer();
        this.setDistanceTravelled(0d);
    }

    private Double getFuel() {
        return this.fuel;
    }

    private void setFuel(Double fuel) {
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

    private void setFuelConsumptionIncrease(Double fuelConsumptionIncrease) {
        this.fuelConsumptionIncrease = fuelConsumptionIncrease;
    }

    private Double getFuelConsumptionDuringSummer() {
        return this.fuelConsumptionDuringSummer;
    }

    private void setFuelConsumptionDuringSummer() {
        this.fuelConsumptionDuringSummer = getFuelConsumption() + getFuelConsumptionIncrease();
    }

    private Double getDistanceTravelled() {
        return this.distanceTravelled;
    }

    private void setDistanceTravelled(Double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public void refuel(Double fuel) {
        setFuel(getFuel() + fuel);
    }

    public void travel(Double distance) {
        if (this.canTravelDistance(distance)) {
            setFuel(getFuel() - (distance * getFuelConsumptionDuringSummer()));
            setDistanceTravelled(distance);
            this.printSuccessfulTravel(distance);
        } else {
            this.printUnsuccessfulTravel();
        }
    }

    private boolean canTravelDistance(Double distance) {
        return distance * getFuelConsumptionDuringSummer() <= getFuel();
    }

    private void printSuccessfulTravel(Double distance) {
        DecimalFormat format = new DecimalFormat("###.######"); // there is surely a better way
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
