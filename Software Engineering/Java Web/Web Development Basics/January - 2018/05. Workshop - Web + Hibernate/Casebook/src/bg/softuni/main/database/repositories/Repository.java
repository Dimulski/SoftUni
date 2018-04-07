package bg.softuni.main.database.repositories;

public interface Repository {
    Object doAction(String action, Object... args);

    public void dismiss();
}
