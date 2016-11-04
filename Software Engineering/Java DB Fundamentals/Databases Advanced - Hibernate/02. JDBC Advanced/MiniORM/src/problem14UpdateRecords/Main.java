package problem14UpdateRecords;

import connection.Connector;
import core.EntityManager;
import entities.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "books");
            EntityManager entityManager = new EntityManager(Connector.getConnection());

            int year = Integer.parseInt(reader.readLine());
            String select = "YEAR(published_on) >= " + year + " AND is_hard_covered = 1";
            Iterable<Book> books = entityManager.find(Book.class, select);
            List<String> updated = new LinkedList<>();
            for (Book book : books) {
                String toUpper = book.getTitle().toUpperCase();
                book.setTitle(toUpper);
                entityManager.persist(book);
                updated.add(toUpper);
            }
            System.out.printf("Books released after %d year: %d\n", year, updated.size());
            updated.stream().sorted().forEach(System.out::println);
        } catch (SQLException | InstantiationException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
    }
}
