package net.java.main.impl.utilities.commands;

import net.java.main.impl.utilities.exceptions.InvalidPositionException;
import net.java.main.impl.utilities.exceptions.UnknownUnitTypeException;
import net.java.main.impl.utilities.models.units.Unit;
import net.java.main.interfaces.Engine;

public class StatusCommand extends CommandImpl {

    public StatusCommand(Engine engine) {
        super(engine);
    }

    @Override
    public Engine getEngine() {
        return this.engine;
    }


    @Override
    public void execute(String[] args) throws UnknownUnitTypeException, InvalidPositionException {
        String unitName = args[1];

        for (Unit unit : this.getEngine().getUnits()) {
            if (unit.getName().equals(unitName)) {
                this.getEngine().getOutputWriter().writeLine(unit);
                return;
            }
        }
    }
}
