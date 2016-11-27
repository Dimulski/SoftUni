package app.domain;

import app.domain.contracts.BillingDetail;

import javax.persistence.*;

@Entity
@Table(name = "billing_details")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BasicBillingDetail implements BillingDetail {

    @Id
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
