package problem15DeleteRecords;

import connection.Connector;
import core.EntityManager;
import entities.Book;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Connector.initConnection("mysql", "root", "1234", "localhost", "3306", "books");
            EntityManager entityManager = new EntityManager(Connector.getConnection());

            String where = " rating < 2 ";
            Iterable<Book> books = entityManager.find(Book.class, where);
            int deletedCount = 0;
            for (Book book : books) {
                entityManager.deleteObject(Book.class, book.getId());
                deletedCount++;
            }

            System.out.printf("%d books have been deleted from the database.", deletedCount);

        } catch (SQLException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
