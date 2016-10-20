package net.java.main.impl.utilities.commands;

import net.java.main.impl.utilities.exceptions.InvalidPositionException;
import net.java.main.impl.utilities.exceptions.NotEnoughEnergyException;
import net.java.main.impl.utilities.exceptions.UnknownUnitTypeException;
import net.java.main.interfaces.Engine;

public class GameOverCommand extends CommandImpl {

    public GameOverCommand(Engine engine) {
        super(engine);
    }

    @Override
    public Engine getEngine() {
        return this.engine;
    }

    @Override
    public void execute(String[] args) throws UnknownUnitTypeException, InvalidPositionException, NotEnoughEnergyException {
        this.getEngine().stop();
        this.getEngine().getOutputWriter().writeLine(String.format("Game over!"));
    }
}
