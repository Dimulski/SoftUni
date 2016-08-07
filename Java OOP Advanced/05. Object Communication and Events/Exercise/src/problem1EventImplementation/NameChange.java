package problem1EventImplementation;

import java.util.EventObject;

public class NameChange extends EventObject {

    private String changedName;

    public NameChange(String changedName) {
        super(changedName);
    }

    public String getChangedName() {
        return (String) super.getSource();
    }
}
