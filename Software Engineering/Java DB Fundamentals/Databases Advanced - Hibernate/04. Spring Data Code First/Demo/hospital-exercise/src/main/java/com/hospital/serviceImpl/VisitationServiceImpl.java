package com.hospital.serviceImpl;

import com.hospital.dao.VisitationDao;
import com.hospital.domain.Visitation;
import com.hospital.service.VisitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitationServiceImpl implements VisitationService {

    @Autowired
    private VisitationDao visitationDao;

    @Override
    public void create(Visitation visitation) {
        this.visitationDao.saveAndFlush(visitation);
    }
}
