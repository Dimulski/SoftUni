package app.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "checking account")
public class CheckingAccount extends BasicBankAccount {

    private BigDecimal fee;

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(String number, BigDecimal balance, BigDecimal fee) {
        super(number, balance);
        this.setFee(fee);
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public void deductFee(BigDecimal fee) {
        BigDecimal newFee = getFee().subtract(fee);
        if (newFee.compareTo(new BigDecimal(0)) < 0) {
            this.setFee(new BigDecimal(0));
        } else {
            this.setFee(newFee);
        }
    }
}
