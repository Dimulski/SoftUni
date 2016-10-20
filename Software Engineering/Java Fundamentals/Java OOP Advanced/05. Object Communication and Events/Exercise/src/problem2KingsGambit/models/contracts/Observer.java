package problem2KingsGambit.models.contracts;

public interface Observer {
    String update(String message);
    void subscribe(Observable observable);
    void unsubscribe();
}
