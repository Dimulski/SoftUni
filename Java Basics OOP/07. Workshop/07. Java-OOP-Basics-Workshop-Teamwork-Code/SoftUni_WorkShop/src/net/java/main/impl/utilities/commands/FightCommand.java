package net.java.main.impl.utilities.commands;

import net.java.main.impl.utilities.exceptions.InvalidPositionException;
import net.java.main.impl.utilities.exceptions.NotEnoughEnergyException;
import net.java.main.impl.utilities.exceptions.UnknownUnitTypeException;
import net.java.main.impl.utilities.models.spells.Spell;
import net.java.main.impl.utilities.models.units.Unit;
import net.java.main.interfaces.Engine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FightCommand extends CommandImpl {

    public FightCommand(Engine engine) {
        super(engine);
    }

    @Override
    public Engine getEngine() {
        return this.engine;
    }

    @Override
    public void execute(String[] args) throws UnknownUnitTypeException, InvalidPositionException, NotEnoughEnergyException {
        List<Unit> killedUnits = new ArrayList<>();

        for (Unit unit : this.getEngine().getUnits()) {
            if (unit.getHealthPoints() <= 0) {
                continue;
            }

            List<Unit> targets = this.getEngine().getBattleground()
                    .getUnitsInRange(unit.getPosition(), unit.getRange())
                    .stream()
                    .filter(u -> u.getHealthPoints() > 0 && !u.equals(unit))
                    .collect(Collectors.toList());
            Unit target = unit.getCombatHandler().pickNextTarget(targets);

            if (target != null) {
                Spell spell = unit.getCombatHandler().generateAttack();
                int damageDelt = spell.getDamage() - target.getDefencePoints();

                if (damageDelt > 0) {
                    target.setHealthPoints(target.getHealthPoints() - spell.getDamage());

                    this.getEngine().getOutputWriter().writeLine(String.format("%s cast %s spell and did %d damage",
                            unit.getName(), spell.getClass().getSimpleName(), spell.getDamage()));

                    if (target.getHealthPoints() <= 0) {
                        target.setHealthPoints(0);
                        this.getEngine().getOutputWriter().writeLine(String.format("%s killed %s",
                                unit.getName(), target.getName()));
                    }
                }

                if (target.getHealthPoints() <= 0) {
                    killedUnits.add(target);
                }
            }
        }

        for (Unit killedUnit : killedUnits) {
            this.getEngine().getBattleground().remove(killedUnit);
        }
    }
}
