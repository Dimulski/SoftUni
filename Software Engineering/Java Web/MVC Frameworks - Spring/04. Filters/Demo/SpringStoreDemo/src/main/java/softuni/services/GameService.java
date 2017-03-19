package softuni.services;

import softuni.models.view.game.GameDetailsView;
import softuni.models.view.game.HomePageGameView;

import java.util.List;

public interface GameService {
    List<HomePageGameView> getAllHomePage();

    GameDetailsView get(Long id);
}
