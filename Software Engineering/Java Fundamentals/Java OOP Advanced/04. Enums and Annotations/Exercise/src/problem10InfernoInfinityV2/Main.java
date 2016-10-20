package problem10InfernoInfinityV2;

import problem10InfernoInfinityV2.core.contracts.Database;
import problem10InfernoInfinityV2.core.DatabaseImpl;
import problem10InfernoInfinityV2.core.contracts.Engine;
import problem10InfernoInfinityV2.core.EngineImpl;
import problem10InfernoInfinityV2.io.ConsoleReader;
import problem10InfernoInfinityV2.io.ConsoleWriter;
import problem10InfernoInfinityV2.io.contracts.Reader;
import problem10InfernoInfinityV2.io.contracts.Writer;

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
