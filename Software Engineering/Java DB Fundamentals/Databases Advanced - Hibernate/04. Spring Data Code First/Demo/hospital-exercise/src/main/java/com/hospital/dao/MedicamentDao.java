package com.hospital.dao;

import com.hospital.domain.Comment;
import com.hospital.domain.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MedicamentDao extends JpaRepository<Medicament, Long> {
}
