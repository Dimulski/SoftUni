package net.java.main.impl.utilities.models.spells;

public class BulletRain extends Spell {

    public static final int ENERGY_COST = 15;

    public BulletRain(Integer damage) {
        super(damage, ENERGY_COST);
    }
}
