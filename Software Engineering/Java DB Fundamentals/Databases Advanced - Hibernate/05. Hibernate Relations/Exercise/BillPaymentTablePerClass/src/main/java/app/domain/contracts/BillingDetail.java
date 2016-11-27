package app.domain.contracts;

import app.domain.User;

import java.io.Serializable;

public interface BillingDetail extends Serializable {

    String getNumber();

    void setNumber(String number);

    User getOwner();

    void setOwner(User owner);
}