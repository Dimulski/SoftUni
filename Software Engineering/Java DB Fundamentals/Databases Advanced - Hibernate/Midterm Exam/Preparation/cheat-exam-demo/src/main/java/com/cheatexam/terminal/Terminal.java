package com.cheatexam.terminal;

import com.cheatexam.domain.AuthorCollection;
import com.cheatexam.domain.dto.AuthorDto;
import com.cheatexam.domain.models.Author;
import com.cheatexam.domain.models.Book;
import com.cheatexam.service.AuthorService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        List<Author> authorList = new ArrayList<>();
        authorList.add(author);
        authorList.add(author);
        String authorJson = gson.toJson(authorList);
        File outputFile = new File("src/main/resources/files/output/json/author.json");
        try (
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));
        ) {
            bufferedWriter.write(authorJson);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        //Read from Json
        //1 read file
        //File inputFile = new File("src/main/resources/files/input/json/vazov.json");
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

        //2 Json read
        Author vazov = gson.fromJson(jsonData.toString(), Author.class);
        vazov.getBooks().stream().forEach(b -> b.setAuthor(vazov));
        this.authorService.create(vazov);


        //write to xml
        JAXBContext jaxbContext = JAXBContext.newInstance(Author.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        File outputXMLFile = new File("src/main/resources/files/output/xml/author.xml");
        jaxbMarshaller.marshal(author, outputXMLFile);

        //read from xml
        //1.read from xml
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        File inputXMLFile = new File("src/main/resources/files/input/xml/author.xml");
        Author authorFromXML = (Author) unmarshaller.unmarshal(inputXMLFile);
        //2 wite to db
        authorFromXML.getBooks().stream().forEach(b -> b.setAuthor(authorFromXML));
        this.authorService.create(authorFromXML);

        // write multiple objects
        AuthorCollection authorCollection = new AuthorCollection();
        authorCollection.getAuthors().add(author);
        authorCollection.getAuthors().add(author);
        JAXBContext jaxbContextCollection = JAXBContext.newInstance(AuthorCollection.class);
        Marshaller marshaller = jaxbContextCollection.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(authorCollection, new File("src/main/resources/files/output/xml/authors.xml"));

        //Entity to dto
        AuthorDto authorDto = new AuthorDto();
        authorDto.setName(author.getName());

        //Dto to Entity
        Author authorEntity = new Author();
        authorEntity.setName(authorDto.getName());
    }
}