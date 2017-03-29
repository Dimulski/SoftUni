package com.social.repositories;

import com.social.entities.Bike;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BikeRepository extends CrudRepository<Bike, Long> {

    @Query(value = "SELECT b FROM Bike AS b")
    List<Bike> findAll();
}
