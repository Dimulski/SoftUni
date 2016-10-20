package problem10InfernoInfinityV2.core.contracts;

import problem10InfernoInfinityV2.weapons.contracts.Weapon;

public interface Database {

    void addWeapon(Weapon weapon);
    Weapon getWeapon(String name);
}
