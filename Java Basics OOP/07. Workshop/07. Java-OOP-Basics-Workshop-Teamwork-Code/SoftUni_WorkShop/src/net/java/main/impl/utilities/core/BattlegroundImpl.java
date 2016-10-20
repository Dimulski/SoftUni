package net.java.main.impl.utilities.core;

import net.java.main.impl.utilities.exceptions.InvalidPositionException;
import net.java.main.impl.utilities.models.Position;
import net.java.main.impl.utilities.models.units.Unit;
import net.java.main.interfaces.Battleground;

import java.util.ArrayList;
import java.util.List;

public class BattlegroundImpl implements Battleground {
    private Unit[][] battleground;

    public BattlegroundImpl(int rows, int cols) {
        this.battleground = new Unit[rows][cols];
    }

    @Override
    public List<Unit> getUnitsInRange(Position position, int range) {
        List<Unit> targets = new ArrayList<>();

        int startRow = Math.max(0, position.getY() - range);
        int endRow = Math.min(this.battleground.length - 1, position.getY() + range);
        int startCol = Math.max(0, position.getX() - range);
        int endCol = Math.min(this.battleground.length - 1, position.getX() + range);

        for (int row = startRow; row <= endRow; row++) {

            for (int col = startCol; col <= endCol; col++) {
                Unit unit = this.battleground[col][row];

                if (unit != null) {
                    targets.add(unit);
                }
            }
        }

        return targets;
    }

    @Override
    public void add(Unit unit) throws InvalidPositionException {
        validatePosition(unit.getPosition());

        if (this.battleground[unit.getPosition().getX()][unit.getPosition().getY()] != null) {
            throw new InvalidPositionException("There is an unit at this position, already!");
        }

        this.battleground[unit.getPosition().getX()][unit.getPosition().getY()] = unit;
    }

    @Override
    public void remove(Unit unit) throws InvalidPositionException {
        validatePosition(unit.getPosition());

        if (this.battleground[unit.getPosition().getX()][unit.getPosition().getY()] == null) {
            throw new InvalidPositionException("There is not unit to remove!");
        }

        this.battleground[unit.getPosition().getX()][unit.getPosition().getY()] = null;
    }

    @Override
    public void move(Unit unit, Position newPosition) throws InvalidPositionException {
        //Validate position
        validatePosition(newPosition);

        //Check is there unit on this position
        if (this.battleground[newPosition.getX()][newPosition.getY()] != null) {
            throw new InvalidPositionException("Threre is an unit on this position, already!");
        }

        //Old position to NULL
        this.battleground[unit.getPosition().getX()][unit.getPosition().getY()] = null;

        //Unit get new position
        unit.setPosition(newPosition);

        //Battleground get new position
        this.battleground[newPosition.getX()][newPosition.getY()] = unit;
    }

    private void validatePosition(Position position) throws InvalidPositionException {
        /*if (!(position.getX() < 0 && position.getX() >= this.battleground.length) &&
        !(position.getY() < 0 || position.getY() >= this.battleground.length)) {
            throw new InvalidPositionException("Coordinates are not correct!");
        }*/
    }
}
