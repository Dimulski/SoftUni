package problem2KingsGambit;

import problem2KingsGambit.core.DatabaseImpl;
import problem2KingsGambit.core.EngineImpl;
import problem2KingsGambit.core.contracts.Database;
import problem2KingsGambit.core.contracts.Engine;
import problem2KingsGambit.io.ConsoleReader;
import problem2KingsGambit.io.ConsoleWriter;
import problem2KingsGambit.io.contracts.Reader;
import problem2KingsGambit.io.contracts.Writer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        Reader reader = new ConsoleReader();
        Writer writer = new ConsoleWriter();
        Database database = new DatabaseImpl();
        Engine engine = new EngineImpl(reader, writer, database);
        engine.run();
    }
}
