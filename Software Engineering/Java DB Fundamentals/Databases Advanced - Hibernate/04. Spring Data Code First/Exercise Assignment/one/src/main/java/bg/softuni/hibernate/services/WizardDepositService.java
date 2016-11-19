package bg.softuni.hibernate.services;

import bg.softuni.hibernate.entities.WizardDeposit;

import java.util.List;

public interface WizardDepositService {

    void persist(WizardDeposit wizardDeposit);

    List<WizardDeposit> findAll();
}
