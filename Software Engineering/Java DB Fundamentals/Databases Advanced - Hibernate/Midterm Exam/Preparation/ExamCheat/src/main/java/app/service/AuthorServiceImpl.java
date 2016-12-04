package app.service;

import app.domain.Author;
import app.repositories.AuthorRepository;
import app.service.contracts.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void create(Author author) {
        this.authorRepository.saveAndFlush(author);
    }

    @Override
    public List<Author> findAuthorByName(String name) {
        return this.authorRepository.findByName(name);
    }
}
