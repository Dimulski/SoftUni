package app.service.contracts;

import app.domain.Patient;

public interface PatientService {

    void create(Patient patient);

    Patient retrieve(long id);
}
