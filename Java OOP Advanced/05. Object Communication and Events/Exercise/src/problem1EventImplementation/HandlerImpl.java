package problem1EventImplementation;

public class HandlerImpl implements NameChangeListener {

    @Override
    public void handleChangedName(NameChange event) {
        System.out.println(String.format("Dispatcher's name changed to %s.", event.getChangedName()));
    }
}
