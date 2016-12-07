package app.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JSONParser {

    private Gson gson;

    @Autowired
    private FileIO fileIO;

    public JSONParser() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .setPrettyPrinting()
                .create();
    }

    public <T> void write(T object, String fileName) throws IOException {
        String content = this.gson.toJson(object);
        this.fileIO.write(content, fileName);
    }

    public <T> T read(Class<T> clazz, String fileName) throws IOException {
        T object = null;
        String content = this.fileIO.read(fileName);
        object = gson.fromJson(content, clazz);
        return object;
    }
}
