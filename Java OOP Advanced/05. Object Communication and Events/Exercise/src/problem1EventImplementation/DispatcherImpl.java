package problem1EventImplementation;

import java.util.ArrayList;
import java.util.List;

public class DispatcherImpl {

    private String name;
    private List<NameChangeListener> listenerList;

    DispatcherImpl() {
        this.setListenerList(new ArrayList<NameChangeListener>());
    }

    public void addNameChangeListener(NameChangeListener listener) {
        listenerList.add(listener);
    }

    public void removeNameChangeListener(NameChangeListener listener) {
        listenerList.remove(listener);
    }

    public void fireNameChangeEvent(String changedName) {
        for (NameChangeListener nameChangeListener : listenerList) {
            nameChangeListener.handleChangedName(new NameChange(changedName));
        }
    }


    private void setListenerList(ArrayList<NameChangeListener> listenerList) {
        this.listenerList = listenerList;
    }
}
