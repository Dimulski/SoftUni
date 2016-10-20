package net.java.main.interfaces;

import net.java.main.impl.utilities.models.units.Unit;

import java.util.List;

public interface Engine {
    List<Unit> getUnits();

    OutputWriter getOutputWriter();

    Battleground getBattleground();

    void start();

    void stop();

    void insetUnit(Unit unit);

    void removeUnit(Unit unit);
}
