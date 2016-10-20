package problem2KingsGambit.commands;

import problem2KingsGambit.models.FootmanImpl;
import problem2KingsGambit.models.contracts.Soldier;
import problem2KingsGambit.core.contracts.Database;

public class CreateKingsFootmenCommand extends Command {

    public CreateKingsFootmenCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        if (getDatabase().getKing() == null) {
            return null;
        }
        String[] input = this.getParams();
        for (String footmanName : input) {
            Soldier footman = new FootmanImpl(footmanName);
            footman.subscribe(getDatabase().getKing());
            getDatabase().getKing().addObserver(footman);
            getDatabase().addFootman(footman);
        }
        return null;
    }
}
