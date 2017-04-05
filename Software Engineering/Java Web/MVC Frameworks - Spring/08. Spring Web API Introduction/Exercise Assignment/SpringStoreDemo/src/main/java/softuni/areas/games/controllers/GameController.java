package softuni.areas.games.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import softuni.areas.games.models.view.GameDetailsView;
import softuni.areas.games.services.GameService;

@Controller
@RequestMapping("games")
public class GameController {
    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("{id}")
    public String details(Model model, @PathVariable Long id) {
        model.addAttribute("view", "games/details");

        GameDetailsView game = gameService.get(id);

        model.addAttribute("game", game);
        model.addAttribute("title", game.getTitle());

        return "base-layout";
    }
}
