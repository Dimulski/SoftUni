package app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "bets_games")
public class BetGame implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "game_id", referencedColumnName = "id")
    private Game game;

    @Id
    @ManyToOne
    @JoinColumn(name = "bet_id", referencedColumnName = "id")
    private Bet bet;

    @ManyToOne(optional = false)
    @JoinColumn(name  = "result_prediction_id", referencedColumnName = "id")
    private ResultPrediction resultPrediction;

    public BetGame() {
        super();
    }

    public BetGame(Game game, Bet bet, ResultPrediction resultPrediction) {
        this.setGame(game);
        this.setBet(bet);
        this.setResultPrediction(resultPrediction);
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public ResultPrediction getResultPrediction() {
        return resultPrediction;
    }

    public void setResultPrediction(ResultPrediction resultPrediction) {
        this.resultPrediction = resultPrediction;
    }
}
