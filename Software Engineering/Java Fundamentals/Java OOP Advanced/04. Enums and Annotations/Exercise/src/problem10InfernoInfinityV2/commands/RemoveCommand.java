package problem10InfernoInfinityV2.commands;

import problem10InfernoInfinityV2.core.contracts.Database;
import problem10InfernoInfinityV2.weapons.contracts.Weapon;

public class RemoveCommand extends Command{

    public RemoveCommand(Database database, String[] params) {
        super(database, params);
    }

    @Override
    public String execute() {
        String[] input = this.getParams();
        String name = input[1];
        Weapon weapon = this.getDatabase().getWeapon(name);
        if (weapon == null){
            return null;
        }

        int index = Integer.valueOf(input[2]);
        weapon.remove(index);
        return null;
    }
}
