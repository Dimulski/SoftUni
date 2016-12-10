package app.io;

import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

@Component
public class XMLParser {

    private JAXBContext jaxbContext;

    private <T> void write(T object, String fileName) throws JAXBException {
        this.jaxbContext = JAXBContext.newInstance(object.getClass());
        try (
                OutputStream outputStream = new FileOutputStream(fileName);
                BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(outputStream));
        ) {
            Marshaller marshaller = this.jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(object, bfw);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> T read(Class<T> clazz, String fileName) {
        return null;
    }
}
