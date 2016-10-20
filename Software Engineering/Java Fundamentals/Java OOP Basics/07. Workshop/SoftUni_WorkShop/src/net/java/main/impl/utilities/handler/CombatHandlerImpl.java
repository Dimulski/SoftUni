package net.java.main.impl.utilities.handler;

import net.java.main.impl.utilities.exceptions.NotEnoughEnergyException;
import net.java.main.impl.utilities.models.spells.Spell;
import net.java.main.impl.utilities.models.units.Unit;
import net.java.main.interfaces.CombatHandler;

import java.util.List;

public abstract class CombatHandlerImpl implements CombatHandler{
    protected Unit unit;

    public CombatHandlerImpl() {
    }

    public abstract void setUnit(Unit unit);

    public abstract Unit pickNextTarget(List<Unit> targetCandidates);

    public abstract Spell generateAttack() throws NotEnoughEnergyException;
}
