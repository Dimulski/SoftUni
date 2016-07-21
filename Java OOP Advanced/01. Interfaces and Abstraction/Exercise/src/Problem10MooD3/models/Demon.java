package Problem10MooD3.models;

public class Demon extends Character {

    private static final Integer HASHED_PASSWORD_MULTIPLIER = 217;
    private Double specialPoints;
    private Integer hashedPassword;

    public Demon(String name, String characterType, Double energy, Integer level) {
        super(name, characterType, level);
        this.setHashedPassword();
        this.setSpecialPoints(energy);
    }

    @Override
    public Double getSpecialPoints() { // One implementation of Character will return Double, another might not...
        return this.specialPoints;
    }

    @Override
    <T> void setSpecialPoints(T energy) {
        this.specialPoints = (Double) energy;
    }

    @Override
    public Integer getHashedPassword() { // Same as the above. Surely, there is a better way.
        return this.hashedPassword;
    }

    @Override
    void setHashedPassword() {
        this.hashedPassword = getUsername().length() * HASHED_PASSWORD_MULTIPLIER;
    }

    @Override
    public String toString() {
        return super.toString() + (getSpecialPoints() * getLevel());
    }
}
