package net.java.main.impl.utilities.models.spells;

public class RageShoot extends Spell {

    public static final int ENERGY_COST = 10;

    public RageShoot(Integer damage) {
        super(damage, ENERGY_COST);
    }
}
