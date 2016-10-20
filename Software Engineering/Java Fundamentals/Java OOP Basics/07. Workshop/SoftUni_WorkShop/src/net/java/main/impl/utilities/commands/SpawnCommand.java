package net.java.main.impl.utilities.commands;

import net.java.main.impl.utilities.core.UnitFactory;
import net.java.main.impl.utilities.exceptions.InvalidPositionException;
import net.java.main.impl.utilities.exceptions.UnknownUnitTypeException;
import net.java.main.impl.utilities.models.enums.UnitType;
import net.java.main.impl.utilities.models.units.Unit;
import net.java.main.interfaces.Engine;

public class SpawnCommand extends CommandImpl {

    public SpawnCommand(Engine engine) {
        super(engine);
    }

    @Override
    public Engine getEngine() {
        return this.engine;
    }

    @Override
    public void execute(String[] args) throws UnknownUnitTypeException, InvalidPositionException {
        UnitType unitType = UnitType.valueOf(args[1]);
        String unitName = args[2];
        int xPosition = Integer.parseInt(args[3]);
        int yPosition = Integer.parseInt(args[4]);

        Unit spawnUnit = UnitFactory.create(unitType, unitName, xPosition, yPosition);

        this.getEngine().insetUnit(spawnUnit);
        this.getEngine().getBattleground().add(spawnUnit);
        this.getEngine().getOutputWriter().writeLine(String.format("%s of type %s has spawn @(%d, %d)",
                spawnUnit.getName(), unitType.toString(), xPosition, yPosition));
    }
}
