package softuni;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoftUniSpringStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftUniSpringStoreApplication.class, args);
    }

    @Bean
    public ModelMapper createMapper() {
        return new ModelMapper();
    }

    @Bean
    public Gson createGson() {
        return new Gson();
    }
}
