package softuni.areas.games.entities;


import softuni.areas.users.entities.User;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 100)
    private String title;

    private double size;

    private double price;

    @Column(columnDefinition = "text")
    private String description;

    private String thumbnail;

    @Size(min = 11, max = 11)
    private String trailer;

    private Date releaseDate;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "games")
    private Set<User> users = new HashSet<>(0);

    public Game() {
    }

    public Game(String title, double size, double price, String description, String thumbnail, String trailer, Date releaseDate) {
        this.title = title;
        this.size = size;
        this.price = price;
        this.description = description;
        this.thumbnail = thumbnail;
        this.trailer = trailer;
        this.releaseDate = releaseDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String ytId) {
        this.trailer = ytId;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
}