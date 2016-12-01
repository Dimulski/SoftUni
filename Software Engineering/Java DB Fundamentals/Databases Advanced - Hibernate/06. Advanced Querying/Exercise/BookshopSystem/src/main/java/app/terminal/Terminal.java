package app.terminal;

import app.domain.Author;
import app.domain.Book;
import app.domain.Category;
import app.domain.enums.AgeRestriction;
import app.domain.enums.EditionType;
import app.repositories.AuthorRepository;
import app.repositories.BookRepository;
import app.repositories.CategoryRepository;
import app.service.contracts.AuthorService;
import app.service.contracts.BookService;
import app.service.contracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    private static Random random = new Random();

    @Override
    public void run(String... strings) throws Exception {

        this.seedDatabase();

        this.printBookTitlesAfterYear2000();

        this.printAuthorsWithBookReleaseBefore1990();

        this.printAuthorsByBookCount();

        this.printBooksByGeorgePowell();

        this.testRelatedBooksFunctionality();

        this.printBookTitlesByAgeRestriction();

        this.printBookTitlesWithGoldenEditionAndCopiesBelow500();

        this.printBooksInSpecificRange();
        
        this.printBooksNotReleasedOn();

        this.printBooksWithGivenCategories();

        this.printBooksWithReleaseDateAfter();

        this.printAuthorsWithFirstNameEndingWith();

        this.printBookTitlesContaining();

        this.printBooksWithAuthorNameStartsWith();

        this.printCountOfBooksWithTitleLongerThan();

        this.printAuthorsOrderedByBookCopiesDesc();

        this.printTotalProfitByCategory();

        this.print3MostRecentBooksFromEachCategory();

        this.printBookInfoByTitle();

        this.increaseBookCopies();

        this.removeBooksWithCopiesLowerThan();

        // ToDo: finish 17.* Stored Procedure
    }

    private void removeBooksWithCopiesLowerThan() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long copies = Long.parseLong(reader.readLine());
        int booksRemoved = this.bookRepository.countBooksWithCopiesLessThan(copies);
        this.bookRepository.removeBooksWithCopiesLessThan(copies);
        System.out.println(booksRemoved + " books were deleted");
    }

    private void increaseBookCopies() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat sdf = new SimpleDateFormat("dd MMMM yyyy");
        long booksCopiesAdded = 0;

        String date = reader.readLine();
        Date releaseDate = sdf.parse(date);
        long numberOfCopies = Long.parseLong(reader.readLine());
        List<Book> booksToAlter = this.bookRepository.findBooksByReleaseDateAfter(releaseDate);
        for (Book book : booksToAlter) {
            book.setCopies(book.getCopies() + numberOfCopies);
            this.bookService.save(book);
            booksCopiesAdded += numberOfCopies;
        }
        System.out.println(booksCopiesAdded);
    }

    private void printBookInfoByTitle() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Object[]> bookInfo = this.bookRepository.findBookInfoByTitle(reader.readLine());
        for (Object[] currentBookInfo : bookInfo) {
            String title = (String) currentBookInfo[0];
            EditionType editionType = (EditionType) currentBookInfo[1];
            AgeRestriction ageRestriction = (AgeRestriction) currentBookInfo[2];
            BigDecimal price = (BigDecimal) currentBookInfo[3];
            System.out.printf("%s %s %s %s\n", title, editionType.name(), ageRestriction.name(), price);
        }
    }

    private void print3MostRecentBooksFromEachCategory() {
        StringBuilder result = new StringBuilder();
        for (Object[] categoryBookCount : this.categoryRepository.findCategoriesAndTheirBookCount()) {
            Category category = (Category) categoryBookCount[0];
            long bookCount = (long) categoryBookCount[1];
            result.append(String.format("--%s: %d books\n", category.getName(), bookCount));

            List<Book> books = this.bookRepository.findBooksByCategoryOrderByReleaseDate(category);
            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                result.append(String.format("\t%s (%s)\n", book.getTitle(), book.getReleaseDate()));
            }
        }
        System.out.println(result);
    }


    private void printTotalProfitByCategory() {
        for (Object[] categoryProfit : this.categoryRepository.findTotalBookProfitByCategory()) {
            Category category = (Category) categoryProfit[0];
            BigDecimal totalProfit = (BigDecimal) categoryProfit[1];
            System.out.printf("%s - $%s\n", category.getName(), totalProfit);
        }
    }

    private void printAuthorsOrderedByBookCopiesDesc() {
        for (Object[] authorCopies : this.authorRepository.findAuthorsByBookCopiesDescending()) {
            Author author = (Author) authorCopies[0];
            long copies = (long) authorCopies[1];
            System.out.println(String.format("%s %s - %d", author.getFirstName(), author.getLastName(), copies));
        }
    }

    private void printCountOfBooksWithTitleLongerThan() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(this.bookRepository.findBooksWithTitlesLongerThan(Integer.parseInt(reader.readLine())));
    }

    private void printBooksWithAuthorNameStartsWith() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.bookRepository.findBooksByAuthor_LastNameStartingWith(reader.readLine())
                .forEach(b -> System.out.printf(
                        "%s (%s %s)\n",
                        b.getTitle(),
                        b.getAuthor().getFirstName(),
                        b.getAuthor().getLastName()));
    }

    private void printBookTitlesContaining() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.bookRepository.findBookByTitleContaining(reader.readLine())
                .forEach(b -> System.out.printf("%s\n", b.getTitle()));
    }

    private void printAuthorsWithFirstNameEndingWith() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.authorRepository.findAuthorsByFirstNameEndingWith(reader.readLine())
                .forEach(a -> System.out.printf(
                        "%s %s\n",
                        a.getFirstName(),
                        a.getLastName()));
    }

    private void printBooksWithReleaseDateAfter() throws IOException, ParseException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        this.bookRepository.findBooksByReleaseDateBefore(sdf.parse(reader.readLine()))
                .forEach(b -> System.out.printf(
                        "%s %s - $%s\n",
                        b.getTitle(),
                        b.getEditionType(),
                        b.getPrice()));
    }

    private void printBooksWithGivenCategories() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] categoryNames = reader.readLine().split("\\s+");
        List<Category> categories = this.categoryRepository.findByNameIn(categoryNames);
        this.bookRepository.findByCategoriesIn(categories)
                .forEach(b -> System.out.printf("%s\n", b.getTitle()));
    }

    private void printBooksNotReleasedOn() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.bookRepository.findBooksNotReleasedOn(Integer.parseInt(reader.readLine()))
                .forEach(b -> System.out
                .printf("%s\n", b.getTitle()));
    }

    private void printBooksInSpecificRange() {
        this.bookRepository.findBooksInSpecificRange()
                .forEach(b -> System.out.printf(
                "%s - $%s\n", b.getTitle(), b.getPrice()));
    }

    private void printBookTitlesWithGoldenEditionAndCopiesBelow500() {
        this.bookRepository.findBooksWithGoldenEditionTypeAndCopiesBelow500()
                .forEach(b -> System
                .out.printf("%s\n", b.getTitle()));
    }

    private void printBookTitlesByAgeRestriction() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        this.bookRepository.findBooksByAgeRestriction(AgeRestriction.valueOf(reader.readLine().toUpperCase()))
                .forEach(b -> System.out.printf
                ("%s\n", b.getTitle()));
        reader.close();
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
            String title = titleBuilder.toString().trim();
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
