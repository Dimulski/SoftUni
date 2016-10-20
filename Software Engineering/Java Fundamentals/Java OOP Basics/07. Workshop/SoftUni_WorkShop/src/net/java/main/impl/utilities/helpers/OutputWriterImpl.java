package net.java.main.impl.utilities.helpers;

import net.java.main.interfaces.OutputWriter;

public class OutputWriterImpl implements OutputWriter {

    @Override
    public void writeLine(String line) {
        System.out.println(line);
    }

    @Override
    public void writeLine(Object line) {
        System.out.println(line);
    }
}
