package com.cheatexam.service;

import com.cheatexam.domain.models.Author;

import java.util.List;

public interface AuthorService {

    void create(Author author);

    List<Author> findAuthorByName(String name);
}

