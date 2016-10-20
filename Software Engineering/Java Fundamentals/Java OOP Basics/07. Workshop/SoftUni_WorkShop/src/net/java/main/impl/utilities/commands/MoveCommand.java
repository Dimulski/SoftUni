package net.java.main.impl.utilities.commands;

import net.java.main.impl.utilities.exceptions.InvalidPositionException;
import net.java.main.impl.utilities.exceptions.NotEnoughEnergyException;
import net.java.main.impl.utilities.exceptions.UnknownUnitTypeException;
import net.java.main.impl.utilities.models.Position;
import net.java.main.impl.utilities.models.units.Unit;
import net.java.main.interfaces.Engine;

public class MoveCommand extends CommandImpl {

    public MoveCommand(Engine engine) {
        super(engine);
    }

    @Override
    public Engine getEngine() {
        return this.engine;
    }

    @Override
    public void execute(String[] args) throws UnknownUnitTypeException, InvalidPositionException, NotEnoughEnergyException {
        String unitName = args[1];
        int xNewPosition = Integer.parseInt(args[2]);
        int yNewPosition = Integer.parseInt(args[3]);
        Position newPosition = new Position(xNewPosition, yNewPosition);

        for (Unit unit : this.getEngine().getUnits()) {
            if (unit.getName().equals(unitName)) {
                this.getEngine().getBattleground().move(unit, newPosition);
                this.getEngine().getOutputWriter().writeLine(String.format("%s moved to (%d, %d)",
                        unit.getName(), newPosition.getX(), newPosition.getY()));

                return;
            }
        }
    }
}
