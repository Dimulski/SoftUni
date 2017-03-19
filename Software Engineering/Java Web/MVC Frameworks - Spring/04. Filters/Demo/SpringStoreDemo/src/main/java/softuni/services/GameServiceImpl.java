package softuni.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Game;
import softuni.exceptions.service.InvalidGameException;
import softuni.models.view.game.GameDetailsView;
import softuni.models.view.game.HomePageGameView;
import softuni.repositories.GameRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }

    public List<HomePageGameView> getAllHomePage(){
        List<Game> games = this.gameRepository.findAll();

        List<HomePageGameView> gameViews = new ArrayList<>();
        for (Game game : games) {
            HomePageGameView homePageGameView = new HomePageGameView();

            this.modelMapper.map(game, homePageGameView);
            homePageGameView.setSummary(game.getDescription());

            gameViews.add(homePageGameView);
        }

        return gameViews;
    }

    @Override
    public GameDetailsView get(Long id) {
        Game game = this.gameRepository.findOne(id);
        if(game == null) {
            throw new InvalidGameException("Invalid Game Id");
        }
        GameDetailsView gameDetailsView = new GameDetailsView();

        this.modelMapper.map(game, gameDetailsView);

        return gameDetailsView;
    }
}
