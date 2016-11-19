package com.hospital.serviceImpl;

import com.hospital.dao.PatientDao;
import com.hospital.domain.Patient;
import com.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientDao patientDao;

    @Override
    public void create(Patient patient) {
        this.patientDao.saveAndFlush(patient);
    }

    @Override
    public Patient retrieve(long id) {
        return patientDao.findOne(id);
    }
}
