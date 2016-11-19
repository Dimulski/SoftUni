package app.service;

import app.domain.Medicament;
import app.repositories.MedicamentRepository;
import app.service.contracts.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentServiceImpl implements MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Override
    public void create(Medicament medicament) {
        this.medicamentRepository.saveAndFlush(medicament);
    }
}
