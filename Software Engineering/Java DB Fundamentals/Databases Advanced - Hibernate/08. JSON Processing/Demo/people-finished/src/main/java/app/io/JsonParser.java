package app.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.Serializable;

@Component
public class JsonParser {

    private Gson gson;

    @Autowired
    private FileParser fileParser;

    public JsonParser() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
        this.fileParser = new FileParser();
    }

    public <T> T importJson(Class<T> clazz, String fileName) throws IOException {
        T object = null;
        String file = this.fileParser.readFile(fileName);
        object = this.gson.fromJson(file, clazz);
        return object;
    }

    public <T> void exportJson(T object, String fileName) throws IOException {
        String content = this.gson.toJson(object);
        this.fileParser.writeFile(fileName, content);
    }
}
