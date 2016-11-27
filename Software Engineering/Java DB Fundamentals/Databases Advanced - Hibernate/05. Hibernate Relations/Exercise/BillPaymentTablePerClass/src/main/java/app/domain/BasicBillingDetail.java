package app.domain;

import app.domain.contracts.BillingDetail;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BasicBillingDetail implements BillingDetail {

    @Id
    // @GeneratedValue(strategy = GenerationType.TABLE)
    private String number;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User owner;

    protected BasicBillingDetail() {
        super();
    }

    protected BasicBillingDetail(String number, User owner) {
        this.setNumber(number);
        this.setOwner(owner);
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public User getOwner() {
        return this.owner;
    }

    @Override
    public void setOwner(User owner) {
        this.owner = owner;
    }
}
