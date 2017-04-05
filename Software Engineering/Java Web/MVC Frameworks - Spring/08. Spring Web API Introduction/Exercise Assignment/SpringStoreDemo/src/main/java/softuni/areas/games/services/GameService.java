package softuni.areas.games.services;

import softuni.areas.games.models.view.GameDetailsView;
import softuni.areas.games.models.view.HomePageGameView;
import softuni.areas.games.models.view.GameInfoView;

import java.util.List;
import java.util.Set;

public interface GameService {
    List<HomePageGameView> getAllHomePage();

    GameDetailsView get(Long id);

    GameInfoView getInfoById(Long id);

    List<String> getTitlesById(Set<Long> order);
}
