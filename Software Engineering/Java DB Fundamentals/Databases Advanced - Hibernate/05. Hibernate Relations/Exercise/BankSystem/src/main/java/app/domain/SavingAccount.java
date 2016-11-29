package app.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "saving account")
public class SavingAccount extends BasicBankAccount {

    private BigDecimal interestRate;

    public SavingAccount() {
        super();
    }

    public SavingAccount(String number, BigDecimal balance, BigDecimal interestRate) {
        super(number, balance);
        this.setInterestRate(interestRate);
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public void addInterest(BigDecimal interest) {
        this.setInterestRate(getInterestRate().add(interest));
    }
}
