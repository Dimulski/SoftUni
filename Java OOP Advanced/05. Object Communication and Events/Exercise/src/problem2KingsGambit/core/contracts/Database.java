package problem2KingsGambit.core.contracts;

import problem2KingsGambit.models.contracts.King;
import problem2KingsGambit.models.contracts.Soldier;

import java.util.Map;

public interface Database {

    King getKing();
    void setKing(King king);
    void addFootman(Soldier footman);
    void addRoyalGuard(Soldier royalGuard);
    Soldier remove(String soldierName);
    Map<String, Soldier> getFootmen();
    Map<String, Soldier> getRoyalGuards();
}
