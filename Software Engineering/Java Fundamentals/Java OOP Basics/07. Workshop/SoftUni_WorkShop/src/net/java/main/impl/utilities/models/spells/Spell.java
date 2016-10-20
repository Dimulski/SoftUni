package net.java.main.impl.utilities.models.spells;

public abstract class Spell {

    private Integer damage;

    private Integer energyCost;

    Spell(Integer damage, Integer energyCost) {
        this.damage = damage;
        this.energyCost = energyCost;
    }

    public Integer getDamage() {
        return damage;
    }

    private void setDamage(Integer damage) {
        this.damage = damage;
    }

    private Integer getEnergyCost() {
        return energyCost;
    }

    private void setEnergyCost(Integer energyCost) {
        this.energyCost = energyCost;
    }
}
