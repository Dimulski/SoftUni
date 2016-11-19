package com.hospital.service;

import com.hospital.domain.Patient;

/**
 * Created by teodo on 04/11/2016.
 */
public interface PatientService {

    void create(Patient patient);

    Patient retrieve(long id);
}
