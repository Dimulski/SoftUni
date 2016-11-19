package app.service;

import app.domain.WizardDeposit;
import app.repositories.WizardDepositRepository;
import app.service.contracts.WizardDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WizardDepositServiceImpl implements WizardDepositService {

    private final WizardDepositRepository wizardDepositRepository;

    @Autowired
    public WizardDepositServiceImpl(WizardDepositRepository wizardDepositRepository) {
        this.wizardDepositRepository = wizardDepositRepository;
    }

    @Override
    public void persist(WizardDeposit wizardDeposit) {
        this.wizardDepositRepository.saveAndFlush(wizardDeposit);
    }
}
