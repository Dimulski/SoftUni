package app.io;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class ConsoleWriter implements Writer {
    @Override
    public void write(String text) {
        System.out.print(text);
    }

    @Override
    public void writeLine(String text) {
        System.out.println(text);
    }
}
