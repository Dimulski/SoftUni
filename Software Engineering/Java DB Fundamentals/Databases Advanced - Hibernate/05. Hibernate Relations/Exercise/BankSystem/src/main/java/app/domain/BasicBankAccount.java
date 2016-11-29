package app.domain;

import app.domain.contracts.BankAccount;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bank_accounts")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class BasicBankAccount implements BankAccount {

    @Id
    private String number;

    @Basic
    private BigDecimal balance;

    protected BasicBankAccount() {
        super();
    }

    protected BasicBankAccount(String number, BigDecimal balance) {
        this.setNumber(number);
        this.setBalance(balance);
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
    public BigDecimal getBalance() {
        return this.balance;
    }

    @Override
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @Override
    public void depositMoney(BigDecimal money) {
        this.setBalance(getBalance().add(money));
    }

    @Override
    public void withdrawMoney(BigDecimal money) {
        if (getBalance().compareTo(money) < 0) {
            throw new IllegalArgumentException("Cannot withdraw more than deposited amount");
        }
        this.setBalance(getBalance().subtract(money));
    }
}
