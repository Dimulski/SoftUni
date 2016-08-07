package problem10InfernoInfinityV2.weapons;

import problem10InfernoInfinityV2.gems.contracts.Gem;
import problem10InfernoInfinityV2.gems.GemImpl;
import problem10InfernoInfinityV2.weapons.contracts.Weapon;

public class WeaponImpl implements Weapon {

    private String name;
    private int minDamage;
    private int maxDamage;
    private int socketsCount;
    private int strength;
    private int agility;
    private int vitality;
    private Gem[] gems;

    public WeaponImpl(String name, int minDamage, int maxDamage, int socketsCount) {
        this.name = name;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.socketsCount = socketsCount;
        this.strength = 0;
        this.agility = 0;
        this.vitality = 0;
        this.gems = new GemImpl[this.socketsCount];
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addGem(Gem gem, int index) {
        if (index < 0 || index >= this.socketsCount) {
            return;
        }
        this.updateStarsRemove(index);
        this.gems[index] = gem;
        this.updateStatusAdd(gem);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= this.socketsCount) {
            return;
        }

        this.updateStarsRemove(index);
        this.gems[index] = null;
    }

    @Override
    public String toString() {
        return String.format(
                "%s: %d-%d Damage, +%d Strength, +%d Agility, +%d Vitality",
                this.name,
                this.minDamage,
                this.maxDamage,
                this.strength,
                this.agility,
                this.vitality);
    }

    private void updateStatusAdd(Gem gem) {
        this.strength += gem.getBonusStrength();
        this.minDamage += 2 * gem.getBonusStrength();
        this.maxDamage += 3 * gem.getBonusStrength();

        this.agility += gem.getBonusAgility();
        this.minDamage += gem.getBonusAgility();
        this.maxDamage += 4 * gem.getBonusAgility();

        this.vitality += gem.getBonusVitality();
    }

    private void updateStarsRemove(int index) {
        if (this.gems[index] == null) {
            return;
        }

        Gem gem = this.gems[index];
        this.strength -= gem.getBonusStrength();
        this.minDamage -= 2 * gem.getBonusStrength();
        this.maxDamage -= 3 * gem.getBonusStrength();

        this.agility -= gem.getBonusAgility();
        this.minDamage -= gem.getBonusAgility();
        this.maxDamage -= 4 * gem.getBonusAgility();

        this.vitality -= gem.getBonusVitality();
    }
}
