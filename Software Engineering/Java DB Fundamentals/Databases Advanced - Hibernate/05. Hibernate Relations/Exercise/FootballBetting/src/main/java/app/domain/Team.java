package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

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

    @Basic
    private Color primaryKitColor;

    @Basic
    private Color secondaryKitColor;

    @Basic
    private Town town;

    @Basic
    private BigDecimal budget;

    public Team() {
        super();
    }

    public Team(String name, String logo, String initials, Color primaryKitColor, Color secondaryKitColor,
                Town town, BigDecimal budget) {
        this.setName(name);
        this.setLogo(logo);
        this.setInitials(initials);
        this.setPrimaryKitColor(primaryKitColor);
        this.setSecondaryKitColor(secondaryKitColor);
        this.setTown(town);
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

    public Town getTown() {
        return town;
    }

    public void setTown(Town town) {
        this.town = town;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }
}
