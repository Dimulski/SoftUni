package problem10InfernoInfinity.enums;

import problem10InfernoInfinity.contracts.Gem;

public enum GemImpl implements Gem { // Not sure if using an enum as a glorified class is a good thing.

    RUBY(7, 2, 5),
    EMERALD(1, 4, 9),
    AMETHYST(2, 8, 4);

    private Integer strength;
    private Integer agility;
    private Integer vitality;

    private GemImpl(Integer strength, Integer agility, Integer vitality) {
        this.setStrength(strength);
        this.setAgility(agility);
        this.setVitality(vitality);
    }

    @Override
    public Integer getStrength() {
        return this.strength;
    }

    @Override
    public Integer getAgility() {
        return this.agility;
    }

    @Override
    public Integer getVitality() {
        return this.vitality;
    }

    private void setStrength(Integer strength) {
        this.strength = strength;
    }

    private void setAgility(Integer agility) {
        this.agility = agility;
    }

    private void setVitality(Integer vitality) {
        this.vitality = vitality;
    }
}
