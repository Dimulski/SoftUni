package com.neckandelbows.serviceImpl;

import com.neckandelbows.dao.BasicShampooDao;
import com.neckandelbows.dao.ProductionBatchDao;
import com.neckandelbows.domain.batches.ProductionBatch;
import com.neckandelbows.domain.shampoos.BasicShampoo;
import com.neckandelbows.service.BasicShampooService;
import com.neckandelbows.service.ProductionBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionBatchServiceImpl implements ProductionBatchService {

    @Autowired
    private ProductionBatchDao productionBatchDao;

    @Override
    public void create(ProductionBatch productionBatch) {
        this.productionBatchDao.saveAndFlush(productionBatch);
    }
}
