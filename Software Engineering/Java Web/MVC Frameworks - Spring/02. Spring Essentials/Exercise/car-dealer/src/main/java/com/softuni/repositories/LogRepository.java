package com.softuni.repositories;

import com.softuni.entities.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
    
    List<Log> findByUserUsernameOrderByDateAsc(String username);

    List<Log> findAllByOrderByDateAsc();
}

