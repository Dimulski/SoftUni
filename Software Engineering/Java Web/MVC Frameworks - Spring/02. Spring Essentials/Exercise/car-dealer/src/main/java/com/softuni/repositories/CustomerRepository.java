package com.softuni.repositories;

import com.softuni.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query(value = "SELECT c FROM Customer AS c ORDER BY c.birthDate ASC, c.isYoungDriver ASC")
    List<Customer> getAllOrderByBirthDateAscIsYoungDriverAsc();

    @Query(value = "SELECT c FROM Customer AS c ORDER BY c.birthDate DESC, c.isYoungDriver ASC")
    List<Customer> getAllOrderByBirthDateDescIsYoungDriverAsc();
}
