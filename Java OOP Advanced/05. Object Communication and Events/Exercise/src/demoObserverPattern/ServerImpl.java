package demoObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements Server {

    private String message;
    private List<Observer> observers;

    public ServerImpl() {
        this.observers = new ArrayList<>();
    }

    public String getScheduleMessage() {
        return this.message;
    }

    @Override
    public void addObserver(Observer observer) {
        if (!this.observers.contains(observer)) {
            this.observers.add(observer);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        if (this.observers.contains(observer)) {
            this.observers.remove(observer);
        }
    }

    public void scheduleDownTime(String message) {
        this.message = message;

        // TODO: Notify all observers
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        List<Observer> clonedObservers = new ArrayList<>(this.observers);

        for (Observer clonedObserver : clonedObservers) {
            clonedObserver.update();
        }
    }
}
