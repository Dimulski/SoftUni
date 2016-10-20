package problem10InfernoInfinityV2.core;

import problem10InfernoInfinityV2.commands.*;
import problem10InfernoInfinityV2.core.contracts.Database;
import problem10InfernoInfinityV2.core.contracts.Engine;
import problem10InfernoInfinityV2.io.contracts.Reader;
import problem10InfernoInfinityV2.io.contracts.Writer;

import java.io.IOException;

public class EngineImpl implements Engine {

    private Reader reader;
    private Writer writer;
    private Database database;

    public EngineImpl(Reader reader, Writer writer, Database database) {
        this.reader = reader;
        this.writer = writer;
        this.database = database;
    }

    @Override
    public void run() throws IOException {
        while (true){
            String[] input = reader.readLine().split(";");
            if (input[0].equals("END")){
                break;
            }

            Command command;

            switch (input[0]){
                case "Create":
                    command = new CreateCommand(this.database, input);
                    break;
                case "Add":
                    command = new AddCommand(this.database, input);
                    break;
                case "Remove":
                    command = new RemoveCommand(this.database, input);
                    break;
                case "Print":
                    command = new PrintCommand(this.database, input);
                    break;
                default:
                    continue;
            }

            String result = command.execute();
            if (result != null){
                writer.write(result);
            }
        }
    }
}
