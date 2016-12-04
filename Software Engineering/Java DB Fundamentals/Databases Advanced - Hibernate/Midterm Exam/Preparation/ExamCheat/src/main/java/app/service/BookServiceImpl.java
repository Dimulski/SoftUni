package app.service;

import app.domain.Book;
import app.repositories.BookRepository;
import app.service.contracts.BookService;
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
