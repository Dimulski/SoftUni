package demoObserverPattern;

public class UserImpl implements User {

    private String username;
    private String emailAddress;
    private Observable observable;

    UserImpl(String username, String emailAddress, Observable observable) {
        this.username = username;
        this.emailAddress = emailAddress;
        this.observable = observable;
    }

    public String getUsername() {
        return this.username;
    }

    private void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    private void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }

    public void update() {
        read();
        unsubscribe();
    }

//    @Override
//    public void subscribe(Observable observable) {
//        this.observable = observable;
//    }

    private void read() {
        System.out.println(this.getUsername() + " received:");
        System.out.println(this.observable.getScheduleMessage());
    }

    public void unsubscribe() {
        this.observable.removeObserver(this);
    }
}
