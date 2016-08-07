package problem10InfernoInfinity.contracts;

public interface Weapon extends WeaponBase {

    WeaponBase getWeaponBase();

    String getName();

    Integer getBonusStrength();

    Integer getBonusAgility();

    Integer getBonusVitality();

    void addGem(Integer socketIndex, Gem gem);

    void removeGem(Integer socketIndex);
}
