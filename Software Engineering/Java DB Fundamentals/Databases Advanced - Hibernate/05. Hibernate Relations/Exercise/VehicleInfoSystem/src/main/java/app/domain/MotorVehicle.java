package app.domain;

import app.domain.contracts.Vehicle;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "motor_vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class MotorVehicle implements Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private String manufacturer;

    @Basic
    private String model;

    @Basic
    private BigDecimal price;

    @Basic
    private int maxSpeed;

    @Basic
    private int numberOfEngines;

    @Basic
    private String engineType;

    @Basic
    private double tankCapacity;

    protected MotorVehicle() {
        super();
    }

    protected MotorVehicle(String manufacturer, String model, BigDecimal price, int maxSpeed,
                           int numberOfEngines, String engineType, double tankCapacity) {
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setPrice(price);
        this.setMaxSpeed(maxSpeed);
        this.setNumberOfEngines(numberOfEngines);
        this.setEngineType(engineType);
        this.setTankCapacity(tankCapacity);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(int numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(double tankCapacity) {
        this.tankCapacity = tankCapacity;
    }
}
