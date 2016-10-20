package demoObserverPattern;

public class Main {

    public static void main(String[] args) {

        Observable server = new ServerImpl();
        Observer gosho_mosho = new UserImpl("gosho_mosho", "gosho_qkia@abv.bg", server);
        Observer mosho_tosho = new UserImpl("mosho_tosho", "tosho_sofiiskiq@gmail.com", null);
        Observer ivan_ivanov = new UserImpl("ivan_ivanov", "ivan_svalqcha@alo.bg", server);


        server.addObserver(gosho_mosho);
        server.addObserver(ivan_ivanov);

        server.scheduleDownTime("Servers will be unavailable tomorrow");

        server.scheduleDownTime("Kopon she ima");
    }
}
