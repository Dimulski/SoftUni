package problem10InfernoInfinityV2.commands;

import problem10InfernoInfinityV2.core.contracts.Database;
import problem10InfernoInfinityV2.enums.GemType;
import problem10InfernoInfinityV2.gems.Amethyst;
import problem10InfernoInfinityV2.gems.Emerald;
import problem10InfernoInfinityV2.gems.contracts.Gem;
import problem10InfernoInfinityV2.gems.Ruby;
import problem10InfernoInfinityV2.weapons.contracts.Weapon;

public class AddCommand extends Command{

    public AddCommand(Database database, String[] params) {
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
        GemType gemType = GemType.valueOf(input[3]);
        Gem gem;
        switch (gemType){
            case RUBY:
                gem = new Ruby();
                break;

            case EMERALD:
                gem = new Emerald();
                break;

            case AMETHYST:
                gem = new Amethyst();
                break;

            default:
                return null;
        }
        weapon.addGem(gem, index);
        return null;
    }
}
