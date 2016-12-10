package app.repositories;

import app.domain.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p.name, p.price, CONCAT(s.firstName, ' ', s.lastName) " +
           "FROM Product AS p JOIN p.seller AS s " +
           "WHERE (p.price BETWEEN 500 AND 1000) AND (p.buyer IS NULL) " +
           "ORDER BY p.price ASC")
    List<Object[]> findProductsInRangeWithoutBuyer();
}
