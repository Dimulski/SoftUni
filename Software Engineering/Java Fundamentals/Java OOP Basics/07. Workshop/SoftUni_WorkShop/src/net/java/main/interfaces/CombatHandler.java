package net.java.main.interfaces;

import net.java.main.impl.utilities.exceptions.NotEnoughEnergyException;
import net.java.main.impl.utilities.models.units.Unit;
import net.java.main.impl.utilities.models.spells.Spell;

import java.util.List;

public interface CombatHandler {

    void setUnit(Unit unit);

    Unit pickNextTarget(List<Unit> targetCandidates);

    Spell generateAttack() throws NotEnoughEnergyException;
}
