package app.terminal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class Terminal implements CommandLineRunner {

    @Override
    public void run(String... strings) throws Exception {
        System.out.println(new BigDecimal(60).compareTo(new BigDecimal(90)));
    }
}
