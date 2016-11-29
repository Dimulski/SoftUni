package app.domain;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "cargo ship")
public class CargoShip extends Ship {

    @Basic
    private int maxLoadInKilograms;

    public CargoShip() {
        super();
    }

    public CargoShip(String manufacturer, String model, BigDecimal price, int maxSpeed,
                     int numberOfEngines, String engineType, double tankCapacity, String nationality,
                     String captainName, int crewSize, int maxLoadInKilograms) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType,
                tankCapacity, nationality, captainName, crewSize);
        this.setMaxLoadInKilograms(maxLoadInKilograms);
    }

    public int getMaxLoadInKilograms() {
        return maxLoadInKilograms;
    }

    public void setMaxLoadInKilograms(int maxLoadInKilograms) {
        this.maxLoadInKilograms = maxLoadInKilograms;
    }
}
