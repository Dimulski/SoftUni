package net.java.main.impl.utilities.commands;

import net.java.main.impl.utilities.exceptions.InvalidPositionException;
import net.java.main.impl.utilities.exceptions.NotEnoughEnergyException;
import net.java.main.impl.utilities.exceptions.UnknownUnitTypeException;
import net.java.main.interfaces.Command;
import net.java.main.interfaces.Engine;

public abstract class CommandImpl implements Command {

    protected Engine engine;

    CommandImpl(Engine engine) {
        this.engine = engine;
    }

    public abstract Engine getEngine();

    public abstract void execute(String[] args) throws UnknownUnitTypeException, InvalidPositionException, NotEnoughEnergyException;
}
