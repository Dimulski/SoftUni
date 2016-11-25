package app.terminal;

import app.service.contracts.CountryService;
import app.service.contracts.TownService;
import app.service.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private UserService userService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private TownService townService;

    @Override
    public void run(String... strings) throws Exception {

    }
}
