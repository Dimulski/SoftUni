package bg.softuni.hibernate;

import bg.softuni.hibernate.entities.WizardDeposit;
import bg.softuni.hibernate.services.WizardDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Component
public class BashSoft implements CommandLineRunner {

    private final WizardDepositService wizardDepositService;

    @Autowired
    public BashSoft(WizardDepositService wizardDepositService) {
        this.wizardDepositService = wizardDepositService;
    }

    @Override
    public void run(String... strings) throws Exception {

        WizardDeposit wz = new WizardDeposit();
        wz.setFirstName("Teo");
        wz.setLastName("Dimitrov");
        wz.setAge(26);
        wz.setMagicWandCreator("Tatko");
        wz.setMagicWandSize(26);
        wz.setDepositAmount(0.0);
        wz.setDepositCharge(0.0);
        wz.setDepositExpirationDate(new Date());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2010,11,21);
        wz.setDepositStartDate(calendar.getTime());
        wz.setIsDepositExpired(true);

        WizardDeposit newTeo = new WizardDeposit();
        newTeo.setFirstName("newTeo");
        newTeo.setLastName("Dimitrov");
        newTeo.setAge(26);
        newTeo.setMagicWandCreator("Tatko");
        newTeo.setMagicWandSize(26);
        newTeo.setDepositAmount(0.0);
        newTeo.setDepositCharge(0.0);
        newTeo.setDepositExpirationDate(new Date());
        calendar = Calendar.getInstance();
        calendar.set(2010,11,21);
        newTeo.setDepositStartDate(calendar.getTime());
        newTeo.setIsDepositExpired(false);

        this.wizardDepositService.persist(wz);
        this.wizardDepositService.persist(newTeo);

        List<WizardDeposit> resutl = this.wizardDepositService.findAll();
        for (WizardDeposit wizardDeposit : resutl) {
            System.out.println(wizardDeposit.getFirstName());
        }
    }
}
