package net.java.main.interfaces;

import net.java.main.impl.utilities.exceptions.InvalidPositionException;
import net.java.main.impl.utilities.models.Position;
import net.java.main.impl.utilities.models.units.Unit;

import java.util.List;

public interface Battleground {

    List<Unit> getUnitsInRange(Position position, int range);

    void add(Unit unit) throws InvalidPositionException;

    void remove(Unit unit) throws InvalidPositionException;

    void move(Unit unit, Position newPosition) throws InvalidPositionException;
}
