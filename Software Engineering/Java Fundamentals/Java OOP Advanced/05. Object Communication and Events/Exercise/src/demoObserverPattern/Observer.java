package demoObserverPattern;

public interface Observer {

    void update();
//    void subscribe(Observable observable);
    void unsubscribe();
}
