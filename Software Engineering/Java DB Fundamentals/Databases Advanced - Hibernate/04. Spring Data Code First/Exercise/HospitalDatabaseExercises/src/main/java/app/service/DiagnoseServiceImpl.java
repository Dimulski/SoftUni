package app.service;

import app.domain.Diagnose;
import app.repositories.DiagnoseRepository;
import app.service.contracts.DiagnoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiagnoseServiceImpl implements DiagnoseService {

    @Autowired
    private DiagnoseRepository diagnoseRepository;

    @Override
    public void create(Diagnose doagnose) {
        this.diagnoseRepository.saveAndFlush(doagnose);
    }
}
