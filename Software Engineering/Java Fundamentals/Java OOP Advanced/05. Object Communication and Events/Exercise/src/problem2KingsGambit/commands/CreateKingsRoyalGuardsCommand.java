package problem2KingsGambit.commands;

import problem2KingsGambit.models.RoyalGuardImpl;
import problem2KingsGambit.models.contracts.Soldier;
import problem2KingsGambit.core.contracts.Database;

public class CreateKingsRoyalGuardsCommand extends Command {

    public CreateKingsRoyalGuardsCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        if (getDatabase().getKing() == null) {
            return null;
        }
        String[] input = this.getParams();
        for (String royalGuardName : input) {
            Soldier royalGuard = new RoyalGuardImpl(royalGuardName);
            royalGuard.subscribe(getDatabase().getKing());
            getDatabase().getKing().addObserver(royalGuard);
            getDatabase().addRoyalGuard(royalGuard);
        }
        return null;
    }
}
