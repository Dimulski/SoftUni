package app.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "ships")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Ship extends MotorVehicle {

    @Basic
    private String nationality;

    @Basic
    private String captainName;

    @Basic
    private int crewSize;

    protected Ship() {
        super();
    }

    protected Ship(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngines, String
            engineType, double tankCapacity, String nationality, String captainName, int crewSize) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.setNationality(nationality);
        this.setCaptainName(captainName);
        this.setCrewSize(crewSize);
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getCaptainName() {
        return captainName;
    }

    public void setCaptainName(String captainName) {
        this.captainName = captainName;
    }

    public int getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(int crewSize) {
        this.crewSize = crewSize;
    }
}
