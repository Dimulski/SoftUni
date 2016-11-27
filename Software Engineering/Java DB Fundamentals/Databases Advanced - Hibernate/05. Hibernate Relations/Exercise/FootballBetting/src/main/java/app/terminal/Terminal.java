package app.terminal;

import app.service.contracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private BetGameService betGameService;
    @Autowired
    private BetService betService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private CompetitionService competitionService;
    @Autowired
    private CompetitionTypeService competitionTypeService;
    @Autowired
    private ContinentService continentService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private GameService gameService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private PlayerStatisticService playerStatisticService;
    @Autowired
    private PositionService positionService;
    @Autowired
    private ResultPredictionService resultPredictionService;
    @Autowired
    private RoundService roundService;
    @Autowired
    private TeamService teamService;
    @Autowired
    private TownService townService;
    @Autowired
    private UserService userService;

    @Override
    public void run(String... strings) throws Exception {

    }
}
