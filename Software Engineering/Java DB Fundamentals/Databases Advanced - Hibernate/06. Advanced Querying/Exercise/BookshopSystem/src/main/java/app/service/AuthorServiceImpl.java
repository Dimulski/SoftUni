package app.service;

import app.domain.Author;
import app.repositories.AuthorRepository;
import app.service.contracts.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void save(Author author) {
        this.authorRepository.save(author);
    }

    @Override
    public void delete(Author author) {
        this.authorRepository.delete(author);
    }

    @Override
    public void delete(long id) {
        this.authorRepository.delete(id);
    }

    @Override
    public Author getAuthor(long id) {
        return this.authorRepository.findById(id);
    }

    @Override
    public Iterable<Author> getAuthors() {
        return this.authorRepository.findAll();
    }

    @Override
    public Iterable<Author> getAuthorsWithBookReleaseBeforeYear(int year) {
        return this.authorRepository.findAuthorsWithBookReleaseBeforeYear(year);
    }

    @Override
    public Iterable<Author> getAuthorsOrderedByBookCountDesc() {
        return this.authorRepository.findAuthorsOrderByBooksSizeDesc();
    }
}
