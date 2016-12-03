package com.cheatexam.serviceImpl;

import com.cheatexam.domain.models.Book;
import com.cheatexam.repository.BookRepository;
import com.cheatexam.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void create(Book book) {
        this.bookRepository.saveAndFlush(book);
    }

    @Override
    public List<Book> findBookByName(String name) {
        return this.bookRepository.findByName(name);
    }
}
