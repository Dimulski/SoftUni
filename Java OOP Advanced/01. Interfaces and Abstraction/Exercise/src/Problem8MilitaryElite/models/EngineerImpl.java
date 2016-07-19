package Problem8MilitaryElite.models;

import Problem8MilitaryElite.Corp;
import Problem8MilitaryElite.contracts.Engineer;
import Problem8MilitaryElite.contracts.Repair;

import java.util.LinkedList;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldier implements Engineer {

    private List<Repair> repairs;

    public EngineerImpl(Integer id, String firstName, String lastName, Double salary, Corp corp) {
        super(id, firstName, lastName, salary, corp);
        this.setRepairs(new LinkedList<Repair>());
    }

    private void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    @Override
    public List<Repair> getRepairs() {
        return this.repairs;
    }

    public void addRepair(Repair repair) {
        this.getRepairs().add(repair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Repairs:%s", System.lineSeparator()));
        for (Repair repair : getRepairs()) {
            sb.append("  ");
            sb.append(repair.toString());
        }
        return super.toString() + sb.toString();
    }
}
