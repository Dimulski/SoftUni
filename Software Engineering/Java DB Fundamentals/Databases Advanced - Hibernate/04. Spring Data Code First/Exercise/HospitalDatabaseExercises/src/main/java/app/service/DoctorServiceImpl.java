package app.service;

import app.domain.Doctor;
import app.repositories.DoctorRepository;
import app.service.contracts.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public void create(Doctor doctor) {
        this.doctorRepository.saveAndFlush(doctor);
    }
}
