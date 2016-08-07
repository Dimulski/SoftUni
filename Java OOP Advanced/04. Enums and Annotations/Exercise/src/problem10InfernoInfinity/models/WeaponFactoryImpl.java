package problem10InfernoInfinity.models;

import problem10InfernoInfinity.contracts.Weapon;
import problem10InfernoInfinity.enums.WeaponBaseImpl;

public class WeaponFactoryImpl {

    public static Weapon createWeapon(String weaponBase, String weaponName) {
        Weapon weapon = new WeaponImpl(WeaponBaseImpl.valueOf(weaponBase), weaponName);
        return weapon;
    }
}
