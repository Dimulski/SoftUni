package com.neckandelbows.service;


import com.neckandelbows.domain.batches.ProductionBatch;
import com.neckandelbows.domain.shampoos.BasicShampoo;

public interface ProductionBatchService {

    void create(ProductionBatch productionBatch);
}
