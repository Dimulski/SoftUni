package com.hospital.serviceImpl;

import com.hospital.dao.MedicamentDao;
import com.hospital.domain.Medicament;
import com.hospital.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentServiceImpl implements MedicamentService{

    @Autowired
    private MedicamentDao medicamentDao;

    @Override
    public void create(Medicament medicament) {
        this.medicamentDao.saveAndFlush(medicament);
    }
}
