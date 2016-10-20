package demoObserverPattern;

public interface Observable {
    String getScheduleMessage();
    void scheduleDownTime(String message);
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();

}
