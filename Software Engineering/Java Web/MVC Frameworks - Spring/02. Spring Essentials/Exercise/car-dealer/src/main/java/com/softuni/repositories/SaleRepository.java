package com.softuni.repositories;

import com.softuni.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Query("SELECT s FROM Sale AS s WHERE s.discount = :discount")
    List<Sale> findAllByDiscount(@Param(value = "discount") Double discount);

    @Query("SELECT s FROM Sale AS s WHERE s.discount > 0.0")
    List<Sale> findAllDiscounted();
}
