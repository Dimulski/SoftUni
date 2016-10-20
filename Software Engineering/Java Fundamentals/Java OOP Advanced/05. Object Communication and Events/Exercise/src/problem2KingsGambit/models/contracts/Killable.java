package problem2KingsGambit.models.contracts;

import problem2KingsGambit.core.contracts.Database;

public interface Killable {

    void kill(Database db);
}
