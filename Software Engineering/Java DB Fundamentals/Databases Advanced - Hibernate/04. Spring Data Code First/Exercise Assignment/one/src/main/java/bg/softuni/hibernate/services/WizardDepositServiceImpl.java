package bg.softuni.hibernate.services;

import bg.softuni.hibernate.entities.WizardDeposit;
import bg.softuni.hibernate.repositories.WizardDepositRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

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

    @Override
    public List<WizardDeposit> findAll() {
        return Collections.unmodifiableList(this.wizardDepositRepository.findAll());
    }
}
