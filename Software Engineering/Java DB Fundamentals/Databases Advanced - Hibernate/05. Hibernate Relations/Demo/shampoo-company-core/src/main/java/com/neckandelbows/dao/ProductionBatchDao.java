package com.neckandelbows.dao;


import com.neckandelbows.domain.batches.ProductionBatch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionBatchDao extends JpaRepository<ProductionBatch, Long>{
}
