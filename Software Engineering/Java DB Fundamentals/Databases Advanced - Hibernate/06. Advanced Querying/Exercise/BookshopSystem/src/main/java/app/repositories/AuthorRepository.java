package app.repositories;

import app.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface AuthorRepository extends JpaRepository<Author, Long> {

    Author findById(long id);

    List<Author> findAll();

    @Query("SELECT a FROM Author AS a JOIN a.books AS b WHERE YEAR(b.releaseDate) < :year GROUP BY a")
    Iterable<Author> findAuthorsWithBookReleaseBeforeYear(@Param(value = "year") int year);

    @Query("SELECT a FROM Author AS a JOIN a.books AS b GROUP BY a ORDER BY COUNT(b) DESC")
    Iterable<Author> findAuthorsOrderByBooksSizeDesc();

    List<Author> findAuthorsByFirstNameEndingWith(String suffix);

    @Query(value = "SELECT a, SUM(b.copies) AS copies " +
            "FROM Book AS b JOIN b.author AS a GROUP BY a ORDER BY copies DESC")
    List<Object[]> findAuthorsByBookCopiesDescending();
}
