package Problem8MilitaryElite.models;

import Problem8MilitaryElite.contracts.Repair;

public class RepairImpl implements Repair{

    private String partName;
    private Integer hoursWorked;

    public RepairImpl(String partName, Integer hoursWorked) {
        this.setPartName(partName);
        this.setHoursWorked(hoursWorked);
    }

    private void setPartName(String partName) {
        this.partName = partName;
    }

    private void setHoursWorked(Integer hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public Integer getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d%s",
                getPartName(),
                getHoursWorked(),
                System.lineSeparator());
    }
}
