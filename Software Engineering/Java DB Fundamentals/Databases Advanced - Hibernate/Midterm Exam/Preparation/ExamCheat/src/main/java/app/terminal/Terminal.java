package app.terminal;

import app.domain.Author;
import app.domain.Book;
import app.service.contracts.AuthorService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private AuthorService authorService;

    @Override
    public void run(String... strings) throws Exception {

        //Author
        Author author = new Author();
        author.setName("Carlos Ruiz Zafón");
        //Book 1
        Book marina = new Book();
        marina.setName("Marina");
        marina.setAuthor(author);
        //Book 2
        Book shadowOfTheWind = new Book();
        shadowOfTheWind.setName("Shadow of the wind");
        shadowOfTheWind.setAuthor(author);
        //Add books
        author.addBook(marina);
        author.addBook(shadowOfTheWind);
        authorService.create(author);

        //Write to JSON
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
        String authorJson = gson.toJson(author);

        File outputFile = new File("src/main/resources/files/output/json/author.json");
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
        ) {
            bufferedWriter.write(authorJson);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }

        //Read from JSON
        File inputFile = new File("src/main/resources/files/input/json/vazov.json");
        StringBuilder jsonData = new StringBuilder();
        try (BufferedReader bfr = new BufferedReader(new FileReader(inputFile));
        ) {
            String line;
            while ((line = bfr.readLine()) != null) {
                jsonData.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Author vazov = gson.fromJson(jsonData.toString(), Author.class);
        vazov.getBooks().stream().forEach(b -> b.setAuthor(vazov));
        this.authorService.create(vazov);
    }

    private void seedData() {

    }
}
