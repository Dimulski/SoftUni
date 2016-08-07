package problem10InfernoInfinity.models;

import problem10InfernoInfinity.contracts.Gem;
import problem10InfernoInfinity.contracts.Weapon;
import problem10InfernoInfinity.contracts.WeaponBase;
import problem10InfernoInfinity.enums.WeaponBaseImpl;

public class WeaponImpl implements Weapon {

    private static final Integer BONUS_STAT_DEFAULT = 0;

    private String name;
    private WeaponBaseImpl weaponBase;
    private Integer minDamage;
    private Integer maxDamage;
    private Integer bonusStrength;
    private Integer bonusAgility;
    private Integer bonusVitality;
    private Integer socketsCount;


    public WeaponImpl(WeaponBaseImpl weaponBase, String name) {
        this.setWeaponBase(weaponBase);
        this.setName(name);
        this.setMinDamage(this.getWeaponBase().getMinDamage());
        this.setMaxDamage(this.getWeaponBase().getMaxDamage());
        this.setBonusStrength(BONUS_STAT_DEFAULT);
        this.setBonusAgility(BONUS_STAT_DEFAULT);
        this.setBonusVitality(BONUS_STAT_DEFAULT);
        this.setSocketsCount(weaponBase.getSockets().length);
    }

    @Override
    public WeaponBase getWeaponBase() {
        return this.weaponBase;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Integer getMinDamage() {
        return this.minDamage;
    }

    @Override
    public Integer getMaxDamage() {
        return this.maxDamage;
    }

    @Override
    public Gem[] getSockets() {
        return this.getWeaponBase().getSockets();
    }

    @Override
    public Integer getBonusStrength() {
        return this.bonusStrength;
    }

    @Override
    public Integer getBonusAgility() {
        return this.bonusAgility;
    }

    @Override
    public Integer getBonusVitality() {
        return this.bonusVitality;
    }

    @Override
    public void addGem(Integer socketIndex, Gem gem) {
        if (socketIndex < 0 || socketIndex >= this.socketsCount){
            return;
        }
        this.updateStarsRemove(socketIndex);
        this.weaponBase.getSockets()[socketIndex] = gem;
        this.updateStatusAdd(gem);
    }

    @Override
    public void removeGem(Integer socketIndex) {
        if (socketIndex < 0 || socketIndex >= this.socketsCount){
            return;
        }

        this.updateStarsRemove(socketIndex);
        this.weaponBase.getSockets()[socketIndex] = null;
    }

    private void updateStatusAdd(Gem gem){
        this.bonusStrength += gem.getStrength();
        this.minDamage += 2 * gem.getStrength();
        this.maxDamage += 3 * gem.getStrength();

        this.bonusAgility += gem.getAgility();
        this.minDamage += gem.getAgility();
        this.maxDamage += 4 * gem.getAgility();

        this.bonusVitality += gem.getVitality();
    }

    private void updateStarsRemove(int index) {
        if (this.weaponBase.getSockets()[index] == null) {
            return;
        }

        Gem gem = this.weaponBase.getSockets()[index];
        this.bonusStrength -= gem.getStrength();
        this.minDamage -= 2 * gem.getStrength();
        this.maxDamage -= 3 * gem.getStrength();

        this.bonusAgility -= gem.getAgility();
        this.minDamage -= gem.getAgility();
        this.maxDamage -= 4 * gem.getAgility();

        this.bonusVitality -= gem.getVitality();
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setWeaponBase(WeaponBaseImpl weaponBase) {
        this.weaponBase = weaponBase;
    }

    private void setMinDamage(Integer minDamage) {
        this.minDamage = minDamage;
    }

    private void setMaxDamage(Integer maxDamage) {
        this.maxDamage = maxDamage;
    }

    private void setBonusStrength(Integer bonusStrength) {
        this.bonusStrength = bonusStrength;
    }

    private void setBonusAgility(Integer bonusAgility) {
        this.bonusAgility = bonusAgility;
    }

    private void setBonusVitality(Integer bonusVitality) {
        this.bonusVitality = bonusVitality;
    }

//    private void changeStrength(Integer strength) {
//        if (strength < 0) {
//            int strengthh = Math.abs(strength);
//            this.setBonusStrength(getBonusStrength() - strengthh);
//            this.setMinDamage(getMinDamage() - (strengthh * 2));
//            this.setMaxDamage(getMaxDamage() - (strengthh * 3));
//            return;
//        }
//        this.setBonusStrength(getBonusStrength() + strength);
//        this.setMinDamage(getMinDamage() + (strength * 2));
//        this.setMaxDamage(getMaxDamage() + (strength * 3));
//
//    }
//
//    private void changeAgility(Integer agility) {
//        if (agility < 0) {
//            int agilityy = Math.abs(agility);
//            this.setBonusAgility(getBonusAgility() - agilityy);
//            this.setMinDamage(getMinDamage() - agilityy);
//            this.setMaxDamage(getMaxDamage() - (4 * agilityy));
//            return;
//        }
//        this.setBonusAgility(getBonusAgility() + agility);
//        this.setMinDamage(getMinDamage() + agility);
//        this.setMaxDamage(getMaxDamage() + (agility * 4));
//    }
//
//    private void changeVitality(Integer vitality) {
//        if (vitality < 0) {
//            int vitalityy = Math.abs(vitality);
//            this.setBonusVitality(getBonusVitality() - vitalityy);
//            return;
//        }
//        this.setBonusVitality(getBonusVitality() + vitality);
//    }

    @Override
    public String toString() {
        return String.format("%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.getName(), this.getMinDamage(), this.getMaxDamage(), this.getBonusStrength(),
                this.getBonusAgility(), this.getBonusVitality());
    }

    private void setSocketsCount(int socketsCount) {
        this.socketsCount = socketsCount;
    }
}
