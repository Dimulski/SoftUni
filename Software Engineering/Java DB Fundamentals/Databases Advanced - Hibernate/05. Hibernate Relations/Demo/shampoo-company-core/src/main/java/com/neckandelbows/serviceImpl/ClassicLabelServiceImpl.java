package com.neckandelbows.serviceImpl;

import com.neckandelbows.dao.ClassicLabelDao;
import com.neckandelbows.dao.ProductionBatchDao;
import com.neckandelbows.domain.batches.ProductionBatch;
import com.neckandelbows.domain.labels.ClassicLabel;
import com.neckandelbows.service.ClassicLabelService;
import com.neckandelbows.service.ProductionBatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassicLabelServiceImpl implements ClassicLabelService {

    @Autowired
    private ClassicLabelDao classicLabelDao;

    @Override
    public void create(ClassicLabel classicLabel) {
        this.classicLabelDao.saveAndFlush(classicLabel);
    }
}
