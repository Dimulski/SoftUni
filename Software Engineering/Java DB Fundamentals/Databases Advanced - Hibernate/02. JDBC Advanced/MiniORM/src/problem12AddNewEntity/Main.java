package problem12AddNewEntity;

import connection.Connector;
import core.EntityManager;
import entities.Book;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "books");
            EntityManager entityManager = new EntityManager(Connector.getConnection());

            Iterable<Book> books = entityManager.find(Book.class,
                    "CHAR_LENGTH(title) > 30 AND is_hard_covered = 1");
            for (Book book : books) {
                String trimmedLength = book.getTitle().substring(0, 30);
                book.setTitle(trimmedLength);
                entityManager.persist(book);
            }
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
