package net.java.main.interfaces;

import net.java.main.impl.utilities.exceptions.InvalidPositionException;
import net.java.main.impl.utilities.exceptions.NotEnoughEnergyException;
import net.java.main.impl.utilities.exceptions.UnknownUnitTypeException;

public interface Command {

    Engine getEngine();

    void execute(String[] args) throws UnknownUnitTypeException, InvalidPositionException, NotEnoughEnergyException;

}
