package problem2KingsGambit.core;

import problem2KingsGambit.commands.*;
import problem2KingsGambit.core.contracts.Database;
import problem2KingsGambit.core.contracts.Engine;
import problem2KingsGambit.io.contracts.Reader;
import problem2KingsGambit.io.contracts.Writer;

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

        String[] kingsName = reader.readLine().split("\\s+");
        Command createKing = new CreateKingCommand(this.database, kingsName);
        createKing.execute();

        String[] royalGuardsNames = reader.readLine().split("\\s+");
        Command createKingsRoyalGuards = new CreateKingsRoyalGuardsCommand(this.database, royalGuardsNames);
        createKingsRoyalGuards.execute();

        String[] footmenNames = reader.readLine().split("\\s+");
        Command createKingsFootmen = new CreateKingsFootmenCommand(this.database, footmenNames);
        createKingsFootmen.execute();

        while (true) {
            String[] inputParams = reader.readLine().split("\\s+");
            if (inputParams[0].equals("End")) {
                break;
            }

            Command command = null;

            switch (inputParams[0]) {
                case "Attack":
                    if (inputParams[1].equals("King")) {
                        command = new AttackKingCommand(this.database, inputParams);
                    }
                    break;
                case "Kill":
                    command = new KillSoldierCommand(this.database, inputParams);
                    break;
            }

            String result = command.execute();
            if (result != null) {
                writer.write(result);
            }
        }
    }
}
