package app.domain;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "bank_accounts")
@DiscriminatorValue(value = "BA")
public class BankAccount extends BasicBillingDetail {

    @Basic
    private String bankName;

    @Basic
    private String swiftCode;

    public BankAccount() {
        super();
    }

    public BankAccount(String number, User owner, String bankName, String swiftCode) {
        super(number, owner);
        this.setBankName(bankName);
        this.setSwiftCode(swiftCode);
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwiftCode() {
        return swiftCode;
    }

    public void setSwiftCode(String swiftCode) {
        this.swiftCode = swiftCode;
    }
}
