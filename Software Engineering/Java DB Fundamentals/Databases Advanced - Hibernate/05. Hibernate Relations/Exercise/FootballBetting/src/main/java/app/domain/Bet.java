package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "bets")
public class Bet implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private BigDecimal betMoney;

    @Basic
    private Date dateAndTimeOfBet;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public Bet() {
        super();
    }

    public Bet(BigDecimal betMoney, Date dateAndTimeOfBet, User user) {
        this.setBetMoney(betMoney);
        this.setDateAndTimeOfBet(dateAndTimeOfBet);
        this.setUser(user);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getBetMoney() {
        return betMoney;
    }

    public void setBetMoney(BigDecimal betMoney) {
        this.betMoney = betMoney;
    }

    public Date getDateAndTimeOfBet() {
        return dateAndTimeOfBet;
    }

    public void setDateAndTimeOfBet(Date dateAndTimeOfBet) {
        this.dateAndTimeOfBet = dateAndTimeOfBet;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
