package app.service.contracts;

import app.domain.Book;

public interface BookService {

    void save(Book book);

    void delete(Book book);

    void delete(long id);

    Book getBook(long id);

    Iterable<Book> getBooks();

    Iterable<Book> getBooksAfterYear(int year);

    Iterable<Book> getBooksByGeorgePowellOrdered();
}
