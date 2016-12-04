package app.service.contracts;

import app.domain.Book;

import java.util.List;

public interface BookService {

    void create(Book book);

    List<Book> findBookByName(String name);
}
