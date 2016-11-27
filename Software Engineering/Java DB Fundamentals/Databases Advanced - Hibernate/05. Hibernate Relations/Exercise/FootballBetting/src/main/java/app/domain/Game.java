package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "games")
public class Game implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @ManyToOne
    @JoinColumn(name = "home_team_id", referencedColumnName = "id")
    private Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "away_team_id", referencedColumnName = "id")
    private Team awayTeam;

    @Basic
    private int homeGoals;

    @Basic
    private int awayGoals;

    @Basic
    private Date dateAndTimeOfGame;

    @Basic
    private BigDecimal homeTeamWinBetRate;

    @Basic
    private BigDecimal awayTeamWinBetRate;

    @Basic
    private BigDecimal drawGameBetRate;

    @ManyToOne
    @JoinColumn(name = "round_id", referencedColumnName = "id")
    private Round round;

    @ManyToOne
    @JoinColumn(name = "competition_id", referencedColumnName = "id")
    private Competition competition;

    public Game() {
        super();
    }

    public Game(Team homeTeam, Team awayTeam, int homeGoals, int awayGoals, Date dateAndTimeOfGame, BigDecimal
            homeTeamWinBetRate, BigDecimal awayTeamWinBetRate, BigDecimal drawGameBetRate, Round round, Competition
            competition) {
        this.setHomeTeam(homeTeam);
        this.setAwayTeam(awayTeam);
        this.setHomeGoals(homeGoals);
        this.setAwayGoals(awayGoals);
        this.setDateAndTimeOfGame(dateAndTimeOfGame);
        this.setHomeTeamWinBetRate(homeTeamWinBetRate);
        this.setAwayTeamWinBetRate(awayTeamWinBetRate);
        this.setDrawGameBetRate(drawGameBetRate);
        this.setRound(round);
        this.setCompetition(competition);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public Date getDateAndTimeOfGame() {
        return dateAndTimeOfGame;
    }

    public void setDateAndTimeOfGame(Date dateAndTimeOfGame) {
        this.dateAndTimeOfGame = dateAndTimeOfGame;
    }

    public BigDecimal getHomeTeamWinBetRate() {
        return homeTeamWinBetRate;
    }

    public void setHomeTeamWinBetRate(BigDecimal homeTeamWinBetRate) {
        this.homeTeamWinBetRate = homeTeamWinBetRate;
    }

    public BigDecimal getAwayTeamWinBetRate() {
        return awayTeamWinBetRate;
    }

    public void setAwayTeamWinBetRate(BigDecimal awayTeamWinBetRate) {
        this.awayTeamWinBetRate = awayTeamWinBetRate;
    }

    public BigDecimal getDrawGameBetRate() {
        return drawGameBetRate;
    }

    public void setDrawGameBetRate(BigDecimal drawGameBetRate) {
        this.drawGameBetRate = drawGameBetRate;
    }

    public Round getRound() {
        return round;
    }

    public void setRound(Round round) {
        this.round = round;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
