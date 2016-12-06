package app.io;

import org.springframework.stereotype.Component;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Component
public class XmlWriter implements Writer {
    @Override
    public void write(String text) {
        throw new NotImplementedException();
    }

    @Override
    public void writeLine(String text) {
        throw new NotImplementedException();
    }
}
