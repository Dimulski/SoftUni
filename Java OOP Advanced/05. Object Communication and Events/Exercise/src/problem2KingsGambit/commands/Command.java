package problem2KingsGambit.commands;

import problem2KingsGambit.commands.contracts.Executable;
import problem2KingsGambit.core.contracts.Database;

public abstract class Command implements Executable {

    private Database database;
    private String[] params;

    protected Command(Database database, String[] params) {
        this.database = database;
        this.params = params;
    }

    protected Database getDatabase() {
        return this.database;
    }

    protected String[] getParams() {
        return this.params;
    }

    public abstract String execute();
}

