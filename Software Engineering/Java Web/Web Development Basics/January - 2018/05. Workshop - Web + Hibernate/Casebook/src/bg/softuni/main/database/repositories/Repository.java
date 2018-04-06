package bg.softuni.main.database.repositories;

public interface Repository {
    public Object doAction(String action, Object... args);
}
