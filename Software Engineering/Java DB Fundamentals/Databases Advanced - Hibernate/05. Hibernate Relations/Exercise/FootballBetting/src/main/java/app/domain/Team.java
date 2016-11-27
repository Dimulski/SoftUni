package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private String name;

    @Basic
    private String logo;

    @Column(length = 3)
    private String initials;

    @ManyToOne
    @JoinColumn(name = "primary_kit_color_id", referencedColumnName = "id")
    private Color primaryKitColor;

    @ManyToOne
    @JoinColumn(name = "secondary_kit_color_id", referencedColumnName = "id")
    private Color secondaryKitColor;

    @ManyToOne
    @JoinColumn(name = "host_town_id", referencedColumnName = "id")
    private Town hostTown;

    @Basic
    private BigDecimal budget;

    @OneToMany(mappedBy = "team", targetEntity = Player.class)
    private Set<Player> players;

    public Team() {
        this.setPlayers(new HashSet<>());
    }

    public Team(String name, String logo, String initials, Color primaryKitColor, Color secondaryKitColor,
                Town hostTown, BigDecimal budget) {
        this();
        this.setName(name);
        this.setLogo(logo);
        this.setInitials(initials);
        this.setPrimaryKitColor(primaryKitColor);
        this.setSecondaryKitColor(secondaryKitColor);
        this.setHostTown(hostTown);
        this.setBudget(budget);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public Color getPrimaryKitColor() {
        return primaryKitColor;
    }

    public void setPrimaryKitColor(Color primaryKitColor) {
        this.primaryKitColor = primaryKitColor;
    }

    public Color getSecondaryKitColor() {
        return secondaryKitColor;
    }

    public void setSecondaryKitColor(Color secondaryKitColor) {
        this.secondaryKitColor = secondaryKitColor;
    }

    public Town getHostTown() {
        return hostTown;
    }

    public void setHostTown(Town hostTown) {
        this.hostTown = hostTown;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
