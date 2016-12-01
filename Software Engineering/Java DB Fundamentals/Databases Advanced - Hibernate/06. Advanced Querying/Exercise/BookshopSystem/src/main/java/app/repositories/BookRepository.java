package app.repositories;

import app.domain.Book;
import app.domain.Category;
import app.domain.enums.AgeRestriction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book, Long> {

    Book findById(long id);

    List<Book> findAll();

    @Query("SELECT b FROM Book AS b WHERE YEAR(b.releaseDate) > :year")
    Iterable<Book> findBooksAfterYear(@Param(value = "year") int year);

    @Query("SELECT b FROM Book AS b JOIN b.author AS a " +
           "WHERE CONCAT(a.firstName, ' ', a.lastName) = 'George Powell' " +
           "ORDER BY b.releaseDate DESC, b.title ASC")
    Iterable<Book> findBooksByGeorgePowellOrdered();

    List<Book> findBooksByAgeRestriction(AgeRestriction ageRestriction);

    @Query(value = "SELECT b FROM Book AS b WHERE b.editionType = 'GOLD' AND b.copies < 500")
    List<Book> findBooksWithGoldenEditionTypeAndCopiesBelow500();

    @Query(value = "SELECT b FROM Book AS b WHERE b.price < 5 OR b.price > 40")
    List<Book> findBooksInSpecificRange();

    @Query(value = "SELECT b FROM Book AS b WHERE YEAR(b.releaseDate) != :year")
    List<Book> findBooksNotReleasedOn(@Param(value = "year") int year);

    List<Book> findByCategoriesIn(List<Category> categories);

    List<Book> findBooksByReleaseDateBefore(Date date);

    List<Book> findBookByTitleContaining(String substring);

    List<Book> findBooksByAuthor_LastNameStartingWith(String substring);

    @Query(value = "SELECT COUNT(b) FROM Book AS b WHERE LENGTH(b.title) > :length")
    int findBooksWithTitlesLongerThan(@Param(value = "length") int length);

    @Query(value = "SELECT b FROM Book AS b JOIN b.categories AS c " +
            "WHERE c = :category ORDER BY b.releaseDate DESC, b.title ASC")
    List<Book> findBooksByCategoryOrderByReleaseDate(@Param(value = "category") Category categoryName);

    @Query(value = "SELECT b.title, b.editionType, b.ageRestriction, b.price FROM Book AS b WHERE b.title = :title")
    List<Object[]> findBookInfoByTitle(@Param(value = "title") String title);

    List<Book> findBooksByReleaseDateAfter(Date date);

    @Query(value = "SELECT COUNT(b) FROM Book AS b WHERE b.copies < :copies")
    int countBooksWithCopiesLessThan(@Param(value = "copies") long copies);

    @Modifying
    @Query(value = "DELETE Book AS b WHERE b.copies < :copies")
    void removeBooksWithCopiesLessThan(@Param(value = "copies") long copies);
}
