package Problem8MilitaryElite.models;

import Problem8MilitaryElite.contracts.Spy;

public class SpyImpl extends Soldier implements Spy {

    private Integer codeNumber;

    public SpyImpl(Integer id, String firstName, String lastName, Integer codeNumber) {
        super(id, firstName, lastName);
        this.setCodeNumber(codeNumber);
    }

    private void setCodeNumber(Integer codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public Integer getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("%sCode Number: %s%s", System.lineSeparator(), getCodeNumber(), System.lineSeparator());
    }
}
