package exercises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import repository.builder.lib.RepositoryBuilder;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        RepositoryBuilder.build("Dao");
        SpringApplication.run(MainApplication.class, args);
    }
}
