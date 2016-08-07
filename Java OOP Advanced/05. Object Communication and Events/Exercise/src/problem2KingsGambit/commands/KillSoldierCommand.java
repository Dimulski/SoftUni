package problem2KingsGambit.commands;

import problem2KingsGambit.models.contracts.Soldier;
import problem2KingsGambit.core.contracts.Database;

public class KillSoldierCommand extends Command {

    public KillSoldierCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String[] input = this.getParams();
        Soldier soldier = getDatabase().remove(input[1]);
        getDatabase().getKing().removeObserver(soldier);
        return null;
    }
}
