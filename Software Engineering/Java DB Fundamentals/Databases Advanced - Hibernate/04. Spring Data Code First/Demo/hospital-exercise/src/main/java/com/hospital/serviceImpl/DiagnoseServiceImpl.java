package com.hospital.serviceImpl;

import com.hospital.dao.DiagnoseDao;
import com.hospital.domain.Diagnose;
import com.hospital.service.DiagnoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnoseServiceImpl implements DiagnoseService{

    @Autowired
    private DiagnoseDao diagnoseDao;

    @Override
    public void create(Diagnose diagnose) {
        this.diagnoseDao.saveAndFlush(diagnose);
    }
}
