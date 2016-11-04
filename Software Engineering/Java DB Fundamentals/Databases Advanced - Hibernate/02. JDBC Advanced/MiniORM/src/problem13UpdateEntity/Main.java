package problem13UpdateEntity;

import connection.Connector;
import core.EntityManager;
import entities.Book;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "books");
            EntityManager entityManager = new EntityManager(Connector.getConnection());

            String filter = "1 = 1 ORDER BY rating DESC, title ASC LIMIT 3";
            Iterable<Book> books = entityManager.find(Book.class, filter);
            books.forEach(b -> System.out.println(String.format("Title: %s, Author: %s, Rating: %s", b.getTitle(), b.getAuthor(), b.getRating())));
        } catch (SQLException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
