package com.cheatexam.serviceImpl;

import com.cheatexam.domain.models.Author;
import com.cheatexam.repository.AuthorRepository;
import com.cheatexam.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public void create(Author author) {
        this.authorRepository.saveAndFlush(author);
    }

    @Override
    public List<Author> findAuthorByName(String name) {
        return this.authorRepository.findByName(name);
    }
}
