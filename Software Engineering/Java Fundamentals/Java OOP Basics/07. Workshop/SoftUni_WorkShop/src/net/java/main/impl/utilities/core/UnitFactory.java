package net.java.main.impl.utilities.core;

import net.java.main.impl.utilities.exceptions.UnknownUnitTypeException;
import net.java.main.impl.utilities.models.enums.UnitType;
import net.java.main.impl.utilities.models.units.Carrier;
import net.java.main.impl.utilities.models.units.Marine;
import net.java.main.impl.utilities.models.units.Unit;

public class UnitFactory {

    public static Unit create(UnitType unitType, String unitName, int xPosition, int yPosition) throws UnknownUnitTypeException {
        switch (unitType) {
            case Carrier: return new Carrier(unitName, xPosition, yPosition);
            case Marine: return new Marine(unitName, xPosition, yPosition);
            default: throw new UnknownUnitTypeException("Provided unit type is unknown!");
        }
    }

}
