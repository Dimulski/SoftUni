package app.terminal;

import app.domain.Author;
import app.domain.Book;
import app.domain.Category;
import app.domain.enums.AgeRestriction;
import app.domain.enums.EditionType;
import app.service.contracts.AuthorService;
import app.service.contracts.BookService;
import app.service.contracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    private static Random random = new Random();

    @Override
    public void run(String... strings) throws Exception {

        this.seedDatabase();

//        this.printBookTitlesAfterYear2000();
//
//        this.printAuthorsWithBookReleaseBefore1990();
//
//        this.printAuthorsByBookCount();
//
//        this.printBooksByGeorgePowell();
//
//        this.testRelatedBooksFunctionality();
    }

    private void testRelatedBooksFunctionality() {
        List<Book> books = (List<Book>) bookService.getBooks();
        List<Book> threeBooks = books.subList(0, 3);

        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(1));
        threeBooks.get(1).getRelatedBooks().add(threeBooks.get(0));
        threeBooks.get(0).getRelatedBooks().add(threeBooks.get(2));
        threeBooks.get(2).getRelatedBooks().add(threeBooks.get(0));

        for (Book book : threeBooks) {
            bookService.save(book);
        }

        for (Book book : threeBooks) {
            System.out.printf("--%s\n", book.getTitle());
            for (Book relatedBook : book.getRelatedBooks()) {
                System.out.println(relatedBook.getTitle());
            }
        }
    }

    private void seedDatabase() throws IOException, ParseException {
        List<Author> authors = this.seedAuthors();
        List<Category> categories = this.seedCategories();
        this.seedBooks(authors, categories);
    }

    private void printBookTitlesAfterYear2000() {
        this.bookService.getBooksAfterYear(2000).forEach(b -> System.out.println(b.getTitle()));
    }

    private void printAuthorsWithBookReleaseBefore1990() {
        this.authorService.getAuthorsWithBookReleaseBeforeYear(1990).forEach(System.out::println);
    }

    private void printAuthorsByBookCount() {
        this.authorService.getAuthorsOrderedByBookCountDesc().forEach(a ->
                System.out.printf("%s - %d books\n", a.toString(), a.getBooks().size()));
    }

    private void printBooksByGeorgePowell() {
        this.bookService.getBooksByGeorgePowellOrdered().forEach(b -> System.out.printf(
                "%s - %s - %s copies\n",
                b.getTitle(),
                b.getReleaseDate(),
                b.getCopies()));
    }

    private void seedBooks(List<Author> authors, List<Category> categories) throws IOException, ParseException {
        BufferedReader booksReader = new BufferedReader(new FileReader("res/books.txt"));
        String line;
        booksReader.readLine();
        while ((line = booksReader.readLine()) != null) {
            String[] data = line.split("\\s+");

            int authorIndex = random.nextInt(authors.size());
            Author author = authors.get(authorIndex);
            EditionType editionType = EditionType.values()[Integer.parseInt(data[0])];
            SimpleDateFormat formatter = new SimpleDateFormat("d/M/yyyy");
            Date releaseDate = formatter.parse(data[1]);
            int copies = Integer.parseInt(data[2]);
            BigDecimal price = new BigDecimal(data[3]);
            AgeRestriction ageRestriction = AgeRestriction.values()[Integer.parseInt(data[4])];
            StringBuilder titleBuilder = new StringBuilder();
            for (int i = 5; i < data.length; i++) {
                titleBuilder.append(data[i]).append(" ");
            }
            titleBuilder.delete(titleBuilder.lastIndexOf(" "), titleBuilder.lastIndexOf(" "));
            String title = titleBuilder.toString();
            int categoryIndex = random.nextInt(categories.size());
            Category category = categories.get(categoryIndex);

            Book book = new Book(title, null, editionType, ageRestriction, price, copies, releaseDate, author);
            this.bookService.save(book);
        }
    }

    private List<Author> seedAuthors() throws IOException {
        BufferedReader buffReader = new BufferedReader(new FileReader("res/authors.txt"));
        String line;
        buffReader.readLine();
        List<Author> authors = new LinkedList<>();
        while ((line = buffReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String firstName = data[0];
            String lastName = data[1];
            Author author = new Author(firstName, lastName);
            this.authorService.save(author);
            authors.add(author);
        }

        return authors;
    }

    private List<Category> seedCategories() throws IOException {
        BufferedReader buffReader = new BufferedReader(new FileReader("res/categories.txt"));
        String line;
        buffReader.readLine();
        List<Category> categories = new LinkedList<>();
        while ((line = buffReader.readLine()) != null) {
            Category category = new Category(line);
            this.categoryService.save(category);
            categories.add(category);
        }

        return categories;
    }
}
