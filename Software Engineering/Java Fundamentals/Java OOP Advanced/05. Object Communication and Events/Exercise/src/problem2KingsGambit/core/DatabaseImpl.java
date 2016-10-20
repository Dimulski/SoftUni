package problem2KingsGambit.core;

import problem2KingsGambit.models.contracts.King;
import problem2KingsGambit.models.contracts.Soldier;
import problem2KingsGambit.core.contracts.Database;

import java.util.LinkedHashMap;
import java.util.Map;

public class DatabaseImpl implements Database {

    private King king;
    private Map<String, Soldier> footmen;
    private Map<String, Soldier> royalGuards;

    public DatabaseImpl() {
        this.footmen = new LinkedHashMap<>();
        this.royalGuards = new LinkedHashMap<>();
    }

    @Override
    public King getKing() {
        return this.king;
    }

    @Override
    public void setKing(King king) {
        this.king = king;
    }

    public void addFootman(Soldier footman) {
        this.footmen.put(footman.getName(), footman);
    }

    public void addRoyalGuard(Soldier royalGuard) {
        this.royalGuards.put(royalGuard.getName(), royalGuard);
    }

    public Soldier remove(String soldierName) {
        Soldier soldier = null;
        if (getFootmen().containsKey(soldierName)) {
            soldier = getFootmen().remove(soldierName);
        } else {
            soldier = getRoyalGuards().remove(soldierName);
        }
        return soldier;
    }

    public Map<String, Soldier> getFootmen() {
        return this.footmen;
    }

    public Map<String, Soldier> getRoyalGuards() {
        return this.royalGuards;
    }
}
