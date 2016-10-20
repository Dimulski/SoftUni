package problem10InfernoInfinityV2.commands;

import problem10InfernoInfinityV2.core.contracts.Database;
import problem10InfernoInfinityV2.enums.WeaponType;
import problem10InfernoInfinityV2.weapons.Axe;
import problem10InfernoInfinityV2.weapons.Knife;
import problem10InfernoInfinityV2.weapons.Sword;
import problem10InfernoInfinityV2.weapons.contracts.Weapon;

public class CreateCommand extends Command{

    public CreateCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String[] input = this.getParams();
        WeaponType type = WeaponType.valueOf(input[1]);
        String name = input[2];
        Weapon weapon;
        switch (type){
            case AXE:
                weapon = new Axe(name);
                break;

            case SWORD:
                weapon = new Sword(name);
                break;

            case KNIFE:
                weapon = new Knife(name);
                break;

            default:
                return null;
        }

        this.getDatabase().addWeapon(weapon);
        return null;
    }
}

