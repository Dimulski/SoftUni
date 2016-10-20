package net.java.main.impl.utilities.handler;

import net.java.main.impl.utilities.comparators.UnitComparator;
import net.java.main.impl.utilities.exceptions.NotEnoughEnergyException;
import net.java.main.impl.utilities.models.spells.RageShoot;
import net.java.main.impl.utilities.models.spells.Spell;
import net.java.main.impl.utilities.models.units.Unit;

import java.util.Collections;
import java.util.List;

import static net.java.main.impl.utilities.comparators.UnitComparator.HEALTH_POINTS;
import static net.java.main.impl.utilities.comparators.UnitComparator.NAME;

public class MarineCombatHandler extends CombatHandlerImpl {

    private static final int CLOSEST_ENEMY = 0;
    private static final int HALF_MARINE_HEALTH = 25;

    public MarineCombatHandler() {
        super();
    }

    @Override
    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public Unit pickNextTarget(List<Unit> targetCandidates) {
        Collections.sort(targetCandidates, UnitComparator.getComparator(HEALTH_POINTS, NAME));

        return targetCandidates.get(CLOSEST_ENEMY);
    }

    @Override
    public Spell generateAttack() throws NotEnoughEnergyException {
        Spell generatedSpell = new RageShoot(getAttackDamage());

        if (this.unit.getEnergyPoints() >= RageShoot.ENERGY_COST) {
            this.unit.setEnergyPoints(this.unit.getEnergyPoints() - RageShoot.ENERGY_COST);

            return generatedSpell;
        }

        throw new NotEnoughEnergyException("Not enough energy to produce the spell!");
    }

    private int getAttackDamage() {
        int baseDamage = this.unit.getAttackPoints();

        if (this.unit.getHealthPoints() <= HALF_MARINE_HEALTH) {
            return baseDamage * 2;
        }

        return baseDamage;
    }
}
