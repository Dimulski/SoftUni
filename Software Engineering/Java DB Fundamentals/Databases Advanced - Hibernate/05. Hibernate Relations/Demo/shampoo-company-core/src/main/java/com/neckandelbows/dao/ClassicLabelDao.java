package com.neckandelbows.dao;


import com.neckandelbows.domain.batches.ProductionBatch;
import com.neckandelbows.domain.labels.ClassicLabel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassicLabelDao extends JpaRepository<ClassicLabel, Long>{
}
