package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "carriages")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class Carriage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private int passengerSeatCapacity;

    @ManyToOne
    @JoinColumn(name = "train_id", referencedColumnName = "id")
    private Train train;

    protected Carriage() {
        super();
    }

    protected Carriage(int passengerSeatCapacity, Train train) {
        this.setPassengerSeatCapacity(passengerSeatCapacity);
        this.setTrain(train);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getPassengerSeatCapacity() {
        return passengerSeatCapacity;
    }

    public void setPassengerSeatCapacity(int passengerSeatCapacity) {
        this.passengerSeatCapacity = passengerSeatCapacity;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
