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

    @Basic
    private Team homeTeam;

    @Basic
    private Team awayTeam; // what?

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

    @Basic
    private Round round; // shouldn't this be a collection

    @Basic
    private Competition competition;

    
}
