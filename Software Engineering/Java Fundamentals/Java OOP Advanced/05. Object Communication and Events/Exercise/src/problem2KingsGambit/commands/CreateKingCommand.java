package problem2KingsGambit.commands;

import problem2KingsGambit.models.KingImpl;
import problem2KingsGambit.models.contracts.King;
import problem2KingsGambit.core.contracts.Database;

public class CreateKingCommand extends Command {

    public CreateKingCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String[] input = this.getParams();
        King king = new KingImpl(input[0]);
        this.getDatabase().setKing(king);
        return null;
    }
}
