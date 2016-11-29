package app.domain;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "car")
public class Car extends MotorVehicle {

    @Basic
    private int numberOfDoors;

    @Basic
    private boolean hasInsurance;

    public Car() {
        super();
    }

    public Car(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngines, String
            engineType, double tankCapacity, int numberOfDoors, boolean hasInsurance) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.setNumberOfDoors(numberOfDoors);
        this.setHasInsurance(hasInsurance);
    }

    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public boolean getHasInsurance() {
        return this.hasInsurance;
    }

    public void setHasInsurance(boolean hasInsurance) {
        this.hasInsurance = hasInsurance;
    }
}
