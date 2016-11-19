package app.terminal;

import app.domain.WizardDeposit;
import app.service.contracts.WizardDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class Terminal implements CommandLineRunner{

    private final WizardDepositService wizardDepositService;

    @Autowired
    public Terminal(WizardDepositService wizardDepositService) {
        this.wizardDepositService = wizardDepositService;
    }

    @Override
    public void run(String... strings) throws Exception {

        WizardDeposit dumbledore = new WizardDeposit();
        dumbledore.setFirstName("Albus");
        dumbledore.setLastName("Dumbledore");
        dumbledore.setAge(115);
        dumbledore.setMagicWandCreator("Antioch Peverell");
        dumbledore.setMagicWandSize(15);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 10, 20);
        Date depositStart = calendar.getTime();
        dumbledore.setDepositStartDate(depositStart);
        calendar.set(2020, 10, 20);
        Date depositEnd = calendar.getTime();
        dumbledore.setDepositExpirationDate(depositEnd);
        dumbledore.setDepositAmount(2000.24);
        dumbledore.setDepositCharge(0.2);
        dumbledore.setIsDepositExpired(false);

        WizardDeposit snape = new WizardDeposit();
        snape.setFirstName("Snape");
        snape.setLastName("Severus");
        snape.setAge(38);
        snape.setMagicWandCreator("Garrick Ollivander");
        snape.setMagicWandSize(12);
        snape.setDepositStartDate(depositStart);
        snape.setDepositExpirationDate(depositEnd);
        snape.setDepositAmount(1000.00);
        snape.setDepositCharge(5.0);
        snape.setIsDepositExpired(false);

        WizardDeposit potter = new WizardDeposit();
        potter.setFirstName("Harry");
        potter.setLastName("Potter");
        potter.setAge(36);
        potter.setMagicWandCreator("Garrick Ollivander");
        potter.setMagicWandSize(11);
        potter.setDepositStartDate(depositStart);
        potter.setDepositExpirationDate(depositEnd);
        potter.setDepositAmount(5000.00);
        potter.setDepositCharge(0.1);
        potter.setIsDepositExpired(false);

        this.wizardDepositService.persist(dumbledore);
        this.wizardDepositService.persist(snape);
        this.wizardDepositService.persist(potter);
    }
}
