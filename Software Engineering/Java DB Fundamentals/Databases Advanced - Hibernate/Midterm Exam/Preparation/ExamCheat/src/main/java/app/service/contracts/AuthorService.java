package app.service.contracts;

import app.domain.Author;

import java.util.List;

public interface AuthorService {

    void create(Author author);

    List<Author> findAuthorByName(String name);
}
