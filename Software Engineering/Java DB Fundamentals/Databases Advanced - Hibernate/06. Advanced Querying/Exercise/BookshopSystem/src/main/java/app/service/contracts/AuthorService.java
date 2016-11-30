package app.service.contracts;

import app.domain.Author;

public interface AuthorService {

    void save(Author author);

    void delete(Author author);

    void delete(long id);

    Author getAuthor(long id);

    Iterable<Author> getAuthors();

    Iterable<Author> getAuthorsWithBookReleaseBeforeYear(int year);

    Iterable<Author> getAuthorsOrderedByBookCountDesc();
}
