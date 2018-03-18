package io;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Writer {

    private Writer() { }

    public static void writeResponseContent(byte[] data, OutputStream outputStream) throws IOException {
        DataOutputStream buffer = new DataOutputStream(outputStream);
        buffer.write(data);
    }
}
