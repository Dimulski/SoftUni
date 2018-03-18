package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Reader {

    private Reader() { }

    public static String readAllLines(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder builder = new StringBuilder();

        while (reader.ready()) {
            builder.append((char) reader.read());
        }

        return builder.toString();
    }
}
