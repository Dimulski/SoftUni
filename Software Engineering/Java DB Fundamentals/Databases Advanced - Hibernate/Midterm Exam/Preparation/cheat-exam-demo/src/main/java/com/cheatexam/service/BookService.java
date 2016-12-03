package com.cheatexam.service;

import com.cheatexam.domain.models.Book;

import java.util.List;

public interface BookService {

    void create(Book book);

    List<Book> findBookByName(String name);
}
