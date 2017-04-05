package softuni.areas.games.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.areas.games.entities.Game;
import softuni.areas.users.exceptions.InvalidGameException;
import softuni.areas.games.models.view.GameDetailsView;
import softuni.areas.games.models.view.HomePageGameView;
import softuni.areas.games.repositories.GameRepository;
import softuni.areas.games.models.view.GameInfoView;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }

    private Game getGameById(Long id) {
        Game game = this.gameRepository.findOne(id);

        if(game == null) {
            throw new InvalidGameException("Invalid Game Id");
        }

        return game;
    }

    @Override
    public List<HomePageGameView> getAllHomePage(){
        List<Game> games = this.gameRepository.findAll();

        List<HomePageGameView> gameViews = new ArrayList<>();
        for (Game game : games) {
            HomePageGameView homePageGameView = new HomePageGameView();

            this.modelMapper.map(game, homePageGameView);

            homePageGameView.validate();
            homePageGameView.setSummary(game.getDescription());

            gameViews.add(homePageGameView);
        }

        return gameViews;
    }

    @Override
    public GameDetailsView get(Long id) {
        Game game = this.getGameById(id);

        GameDetailsView gameDetailsView = new GameDetailsView();

        this.modelMapper.map(game, gameDetailsView);

        return gameDetailsView;
    }


    @Override
    public GameInfoView getInfoById(Long id) {
        Game game = this.getGameById(id);

        GameInfoView gameInfoView = new GameInfoView();

        this.modelMapper.map(game, gameInfoView);

        return gameInfoView;
    }

    @Override
    public List<String> getTitlesById(Set<Long> order) {

        List<String> titles = new ArrayList<>();

        for(Long gameId : order){
            Game game = this.getGameById(gameId);

            titles.add(game.getTitle());
        }
        
        return titles;
    }
}
