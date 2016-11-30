package app.repositories;

import app.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    Author findById(long id);

    Iterable<Author> findAll();

    @Query("SELECT a FROM Author AS a JOIN a.books AS b WHERE YEAR(b.releaseDate) < :year GROUP BY a")
    Iterable<Author> findAuthorsWithBookReleaseBeforeYear(@Param(value = "year") int year);

    @Query("SELECT a FROM Author AS a JOIN a.books AS b GROUP BY a ORDER BY COUNT(b) DESC")
    Iterable<Author> findAuthorsOrderByBooksSizeDesc();
}
