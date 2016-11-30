package app.service;

import app.domain.Book;
import app.repositories.BookRepository;
import app.service.contracts.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }

    @Override
    public void delete(Book book) {
        this.bookRepository.delete(book);
    }

    @Override
    public void delete(long id) {
        this.bookRepository.delete(id);
    }

    @Override
    public Book getBook(long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Iterable<Book> getBooks() {
        return this.bookRepository.findAll();
    }

    @Override
    public Iterable<Book> getBooksAfterYear(int year) {
        return this.bookRepository.findBooksAfterYear(year);
    }

    @Override
    public Iterable<Book> getBooksByGeorgePowellOrdered() {
        return this.bookRepository.findBooksByGeorgePowellOrdered();
    }


}
