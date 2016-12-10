package app.terminal;

import app.domain.dtos.xml.AlbumXmlDto;
import app.domain.dtos.xml.CatalogXmlDto;
import app.parser.FileParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    @Qualifier(value = "XMLParser")
    private FileParser xmlParser;



    @Override
    public void run(String... strings) throws Exception {
        this.printAlbums();
    }

    private void printAlbums() {
        CatalogXmlDto catalogXmlDto = null;
        try {
            catalogXmlDto = this.xmlParser.read(CatalogXmlDto.class, "/files/input/xml/catalog.xml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (AlbumXmlDto album : catalogXmlDto.getAlbums()) {
            System.out.println(album);
        }
    }
}
