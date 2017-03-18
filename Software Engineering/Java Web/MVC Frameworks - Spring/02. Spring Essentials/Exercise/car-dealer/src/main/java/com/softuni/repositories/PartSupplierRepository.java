package com.softuni.repositories;

import com.softuni.entities.PartSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartSupplierRepository extends JpaRepository<PartSupplier, Long> {

    List<PartSupplier> findAllByIsImporter(Boolean isImporter);
}
