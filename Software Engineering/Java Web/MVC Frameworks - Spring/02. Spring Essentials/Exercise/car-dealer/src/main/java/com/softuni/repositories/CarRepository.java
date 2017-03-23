package com.softuni.repositories;

import com.softuni.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    @Query(value = "SELECT c FROM Car AS c WHERE c.make = :make ORDER BY c.model ASC, c.travelledDistance DESC")
    List<Car> findByMakeOrderByModelAscTravelledDistanceDesc(@Param(value = "make") String make);

    @Query(value = "SELECT c FROM Car AS c ORDER BY c.model ASC, c.travelledDistance DESC")
    List<Car> findAllOrderByModelAscTravelledDistanceDesc();
    
    Car findFirstByMake(String make);
}
