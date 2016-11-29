package app.domain.contracts;

import java.io.Serializable;
import java.math.BigDecimal;

public interface BankAccount extends Serializable {

    String getNumber();

    void setNumber(String number);

    BigDecimal getBalance();

    void setBalance(BigDecimal balance);

    void depositMoney(BigDecimal money);

    void withdrawMoney(BigDecimal money);
}
