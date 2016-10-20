package problem10InfernoInfinityV2.weapons.contracts;

import problem10InfernoInfinityV2.gems.contracts.Gem;

public interface Weapon {

    void addGem(Gem gem, int index);
    void remove(int index);
    String getName();
}
