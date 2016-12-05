package app.terminal;

import app.domain.Author;
import app.domain.AuthorCollection;
import app.domain.Book;
import app.domain.dto.AuthorDto;
import app.service.contracts.AuthorService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Read from JSON
        InputStream inputStream = getClass().getResourceAsStream("/files/input/json/vazov.json");
        StringBuilder jsonData = new StringBuilder();
        try (BufferedReader bfr = new BufferedReader(new InputStreamReader(inputStream));
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

        //Write to XML
        JAXBContext jaxbContext = JAXBContext.newInstance(author.getClass());
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File outputXMLFile = new File("src/main/resources/files/output/xml/author.xml");
        jaxbMarshaller.marshal(author, outputXMLFile);

        //Read from XML
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File inputXMLFile = new File("src/main/resources/files/input/xml/author.xml");
        Author authorFromXML = (Author) unmarshaller.unmarshal(inputXMLFile);
        //Write to db
        authorFromXML.getBooks().stream().forEach(b -> b.setAuthor(authorFromXML));
        this.authorService.create(authorFromXML);

        //Write multiple authors
        AuthorCollection authorCollection = new AuthorCollection();
        authorCollection.getAuthors().add(author);
        authorCollection.getAuthors().add(vazov);

        JAXBContext jaxbContextCollection = JAXBContext.newInstance(AuthorCollection.class);
        Marshaller  marshaller = jaxbContextCollection.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(authorCollection, new File("src/main/resources/files/output/xml/authors.xml"));

        //Entity to dto
        AuthorDto dto = new AuthorDto();
        dto.setName(author.getName());

        //Dto to entity
        Author authorEntity = new Author();
        authorEntity.setName(dto.getName());
    }
}
