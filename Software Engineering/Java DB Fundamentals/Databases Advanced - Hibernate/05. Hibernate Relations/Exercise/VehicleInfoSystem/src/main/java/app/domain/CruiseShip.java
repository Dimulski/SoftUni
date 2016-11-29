package app.domain;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "cruise ship")
public class CruiseShip extends Ship {

    @Basic
    private int passengerCapacity;

    public CruiseShip() {
        super();
    }

    public CruiseShip(String manufacturer, String model, BigDecimal price, int maxSpeed,
                      int numberOfEngines, String engineType, double tankCapacity, String nationality,
                      String captainName, int crewSize, int passengerCapacity) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity, nationality,
                captainName, crewSize);
        this.setPassengerCapacity(passengerCapacity);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity(int passengerCapacity) {
        this.passengerCapacity = passengerCapacity;
    }
}
