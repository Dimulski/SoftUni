package problem2KingsGambit.models.contracts;

public interface Observable {

    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    String notifyObservers();
}
