package Problem8MilitaryElite.models;

import Problem8MilitaryElite.contracts.LieutenantGeneral;
import Problem8MilitaryElite.contracts.Private;

import java.util.LinkedList;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private List<Private> privates;

    public LieutenantGeneralImpl(Integer id, String firstName, String lastName, Double salary) {
        super(id, firstName, lastName, salary);
        this.setPrivates(new LinkedList<Private>());
    }

    private void setPrivates(List<Private> privates) {
        this.privates = privates;
    }

    @Override
    public List<Private> getPrivates() {
        return this.privates;
    }

    public void addPrivate(Private privateInstance) {
        this.getPrivates().add(privateInstance);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Privates:%s", System.lineSeparator()));
        for (Private privateInstance : getPrivates()) {
            sb.append("  ");
            sb.append(privateInstance.toString());
        }
        return super.toString() + sb.toString();
    }
}
