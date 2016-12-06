package app.core.commands;


import app.domain.model.Town;
import app.service.TownService;
import org.springframework.beans.factory.annotation.Autowired;

public class AddTownCommand extends Command {

    @Autowired
    private TownService townService;

    protected AddTownCommand(String[] data) {
        super(data);
    }

    /**
     * AddTown <townName> <countryName>
     */
    @Override
    public String execute() {
        String townName = this.getData()[1];
        String countryName = this.getData()[2];
        Town town = new Town();
        town.setName(townName);
        town.setCountry(countryName);
        townService.create(town);
        return townName + " was added to database";
    }
}
