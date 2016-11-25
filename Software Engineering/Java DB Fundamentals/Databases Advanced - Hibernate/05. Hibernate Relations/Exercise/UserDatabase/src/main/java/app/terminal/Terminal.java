package app.terminal;

import app.domain.Country;
import app.domain.Town;
import app.domain.User;
import app.service.contracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private CountryService countryService;

    @Autowired
    private PictureService pictureService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TownService townService;

    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {

        Country bulgaria = new Country("Bulgaria");
        Town sofia = new Town("Sofia", bulgaria);
        User pesho = new User("pesho96", "Pesho", "Peshev", "pesho123", "pesho@abv.bg",
                new Date(), new Date(), 20, null, false, sofia, sofia);
        User ivan = new User("vankata", "Ivan", "Ivanov", "ivan321", "ivan@abv.bg",
                new Date(), new Date(), 20, null, false, sofia, sofia);
        pesho.addFriend(ivan);
        this.countryService.create(bulgaria);
        this.townService.create(sofia);
        this.userService.create(ivan);
        this.userService.create(pesho);
    }
}
