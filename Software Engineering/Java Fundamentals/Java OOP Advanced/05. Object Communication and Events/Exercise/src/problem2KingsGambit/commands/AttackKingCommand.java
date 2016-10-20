package problem2KingsGambit.commands;

import problem2KingsGambit.core.contracts.Database;

public class AttackKingCommand extends Command {

    public AttackKingCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {

        return getDatabase().getKing().respondToAttack();
    }
}
