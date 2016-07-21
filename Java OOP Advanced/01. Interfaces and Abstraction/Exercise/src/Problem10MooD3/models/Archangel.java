package Problem10MooD3.models;

public class Archangel extends Character {

    private static final Integer HASHED_PASSWORD_MULTIPLIER = 21;
    private Integer specialPoints;
    private String hashedPassword;

    public Archangel(String name, String characterType, Integer mana, Integer level) {
        super(name, characterType, level);
        this.setHashedPassword();
        this.setSpecialPoints(mana);
    }

    @Override
    public Integer getSpecialPoints() {
        return this.specialPoints;
    }

    @Override
    <T> void setSpecialPoints(T specialPoints) {
        this.specialPoints = (Integer) specialPoints;
    }

    @Override
    public String getHashedPassword() { // For the hashed password - They could always just return a String, or maybe Object.
        return this.hashedPassword;
    }

    @Override
    void setHashedPassword() {
        String reversedUsername = new StringBuilder(getUsername()).reverse().toString();
        this.hashedPassword = reversedUsername + (getUsername().length() * HASHED_PASSWORD_MULTIPLIER);
    }

    public String toString() {
        return super.toString() + (getSpecialPoints() * getLevel());
    }
}
