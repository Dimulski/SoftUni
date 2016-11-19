package com.hospital.dao;

import com.hospital.domain.Comment;
import com.hospital.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PatientDao extends JpaRepository<Patient, Long> {
}
