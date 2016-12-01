package app.repositories;

import app.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findById(long id);

    List<Category> findAll();

    List<Category> findByNameIn(String[] names);

    @Query(value = "SELECT c, SUM(b.copies * b.price) AS tp " +
            "FROM Book AS b JOIN b.categories AS c GROUP BY c ORDER BY tp DESC, c.name ASC")
    List<Object[]> findTotalBookProfitByCategory();

    @Query(value = "SELECT c, COUNT(b) AS bc FROM Book AS b JOIN b.categories AS c " +
            "GROUP BY c HAVING COUNT(b) > 35 ORDER BY bc DESC")
    List<Object[]> findCategoriesAndTheirBookCount();
}
