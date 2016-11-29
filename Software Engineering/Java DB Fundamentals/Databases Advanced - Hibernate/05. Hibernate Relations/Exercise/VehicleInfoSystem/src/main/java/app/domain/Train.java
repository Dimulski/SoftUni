package app.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue(value = "train")
public class Train extends MotorVehicle {

    @OneToOne
    @JoinColumn(name = "locomotive_id", referencedColumnName = "id")
    private Locomotive locomotive;

    @Basic
    private int numberOfCarriages;

    @OneToMany(mappedBy = "train", targetEntity = Carriage.class)
    private Set<Carriage> carriages;

    public Train() {
        this.setCarriages(new HashSet<>());
    }

    public Train(String manufacturer, String model, BigDecimal price, int maxSpeed, int numberOfEngines, String
            engineType, double tankCapacity, Locomotive locomotive, int numberOfCarriages) {
        super(manufacturer, model, price, maxSpeed, numberOfEngines, engineType, tankCapacity);
        this.setCarriages(new HashSet<>());
        this.setLocomotive(locomotive);
        this.setNumberOfCarriages(numberOfCarriages);
    }

    public Locomotive getLocomotive() {
        return locomotive;
    }

    public void setLocomotive(Locomotive locomotive) {
        this.locomotive = locomotive;
    }

    public int getNumberOfCarriages() {
        return numberOfCarriages;
    }

    public void setNumberOfCarriages(int numberOfCarriages) {
        this.numberOfCarriages = numberOfCarriages;
    }

    public Set<Carriage> getCarriages() {
        return carriages;
    }

    public void setCarriages(Set<Carriage> carriages) {
        this.carriages = carriages;
    }
}
