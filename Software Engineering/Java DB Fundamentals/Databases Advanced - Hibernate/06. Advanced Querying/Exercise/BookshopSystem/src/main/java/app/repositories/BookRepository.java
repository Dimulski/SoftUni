package app.repositories;

import app.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

    Book findById(long id);

    Iterable<Book> findAll();

    @Query("SELECT b FROM Book AS b WHERE YEAR(b.releaseDate) > :year")
    Iterable<Book> findBooksAfterYear(@Param(value = "year") int year);

    @Query("SELECT b FROM Book AS b JOIN b.author AS a " +
           "WHERE CONCAT(a.firstName, ' ', a.lastName) = 'George Powell' " +
           "ORDER BY b.releaseDate DESC, b.title ASC")
    Iterable<Book> findBooksByGeorgePowellOrdered();
}
