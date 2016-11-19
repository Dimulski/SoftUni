package app.service;

import app.domain.Patient;
import app.repositories.PatientRepository;
import app.service.contracts.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public void create(Patient patient) {
        this.patientRepository.saveAndFlush(patient);
    }

    @Override
    public Patient retrieve(long id) {
        return patientRepository.findOne(id);
    }
}
