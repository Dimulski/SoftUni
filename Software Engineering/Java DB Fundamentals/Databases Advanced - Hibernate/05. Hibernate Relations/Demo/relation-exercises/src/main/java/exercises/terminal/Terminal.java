package exercises.terminal;

import exercises.dataFactory.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private DataFactory dataFactory;

    @Override
    public void run(String... strings) throws Exception {
        this.dataFactory.seed();
        List<Object[]> courses = this.dataFactory.getCourses();

        for (Object[] course : courses) {
            String name = (String) course[0];
            System.out.println(name);
        }
    }
}
