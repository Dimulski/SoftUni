package net.java.main.impl.utilities.models.units;

import net.java.main.impl.utilities.models.Position;
import net.java.main.interfaces.CombatHandler;

public abstract class Unit {

    private String name;
    private Integer range;
    private Position position;
    private Integer healthPoints;
    private Integer energyPoints;
    private Integer attackPoints;
    private Integer defencePoints;
    private CombatHandler combatHandler;

    public Unit(
            String name,
            Integer range,
            Integer xPosition,
            Integer yPosition,
            Integer healthPoints,
            Integer energyPoints,
            Integer attackPoints,
            Integer defencePoints,
            CombatHandler combatHandler) {
        this.name = name;
        this.range = range;
        this.healthPoints = healthPoints;
        this.energyPoints = energyPoints;
        this.attackPoints = attackPoints;
        this.defencePoints = defencePoints;
        this.combatHandler = combatHandler;
        this.combatHandler.setUnit(this);

        this.position = new Position(xPosition, yPosition);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(Integer range) {
        this.range = range;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(Integer healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getEnergyPoints() {
        return energyPoints;
    }

    public void setEnergyPoints(Integer energyPoints) {
        this.energyPoints = energyPoints;
    }

    public Integer getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(Integer attackPoints) {
        this.attackPoints = attackPoints;
    }

    public Integer getDefencePoints() {
        return defencePoints;
    }

    public void setDefencePoints(Integer defencePoints) {
        this.defencePoints = defencePoints;
    }

    public CombatHandler getCombatHandler() {
        return combatHandler;
    }

    public void setCombatHandler(CombatHandler combatHandler) {
        this.combatHandler = combatHandler;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("->%s %n", this.getName()));
        stringBuilder.append(String.format("- Type: %s%n", this.getClass().getSimpleName()));

        if (this.getHealthPoints() > 0) {
            stringBuilder.append(String.format("- Position: %s%n", this.getPosition()));
            stringBuilder.append(String.format("- Attack Points: %d%n", this.getAttackPoints()));
            stringBuilder.append(String.format("- Defence Points: %d%n", this.getDefencePoints()));
            stringBuilder.append(String.format("- Energy Points: %d%n", this.getEnergyPoints()));
            stringBuilder.append(String.format("- Health Points: %d", this.getHealthPoints()));
        } else {
            stringBuilder.append("(DEAD)");
        }

        return stringBuilder.toString();
    }
}
