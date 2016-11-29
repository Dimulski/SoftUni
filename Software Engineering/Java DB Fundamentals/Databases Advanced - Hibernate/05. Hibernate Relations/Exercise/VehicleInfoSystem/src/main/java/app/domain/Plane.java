package app.domain;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "plane")
public class Plane extends MotorVehicle {

    @Basic
    private String airlineOwner;

    @Basic
    private String color;

    @Basic
    private int passengerCapacity;

    public Plane() {
        super();
    }

    public Plane(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngines, String
            engineType, double tankCapacity, String airlineOwner, String color, int passengerCapacity) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.setAirlineOwner(airlineOwner);
        this.setColor(color);
        this.setPassengerCapacity(passengerCapacity);
    }

    public String getAirlineOwner() {
        return airlineOwner;
    }

    public void setAirlineOwner(String airlineOwner) {
        this.airlineOwner = airlineOwner;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
