package app.terminal;

import app.domain.BankAccount;
import app.domain.BasicBillingDetail;
import app.domain.CreditCard;
import app.domain.User;
import app.service.contracts.BasicBillingDetailService;
import app.service.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private BasicBillingDetailService basicBillingDetailService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {
        User pesho = new User("Pesho", "Peshev", "pesho@abv.bg", "pesho123");
        this.userService.create(pesho);
        BasicBillingDetail bankAccount = new BankAccount("592", pesho, "UniCredit Bulbank", "19S51G2AX");
        BasicBillingDetail creditCard = new CreditCard("124", pesho, "Secured", 12, 2017);
        this.basicBillingDetailService.create(bankAccount);
        this.basicBillingDetailService.create(creditCard);
    }
}
