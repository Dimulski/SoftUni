package Problem8MilitaryElite.models;

import Problem8MilitaryElite.Corp;

abstract class SpecialisedSoldier extends PrivateImpl implements Problem8MilitaryElite.contracts.SpecialisedSoldier {

    private Corp corp;

    SpecialisedSoldier(Integer id, String firstName, String lastName, Double salary, Corp corp) {
        super(id, firstName, lastName, salary);
        this.setCorps(corp);
    }

    private void setCorps(Corp corp) {
        if (!corp.equals(Corp.Airforces) && !corp.equals(Corp.Marines)) {
            throw new IllegalArgumentException("Invalid corps!");
        }
        this.corp = corp;
    }

    public Corp getCorps() {
        return this.corp;
    }

    @Override
    public String toString() {
        return super.toString() +
                String.format("Corps: %s%s", getCorps(), System.lineSeparator());
    }
}
