package entities;

import persistence.*;

import java.util.Date;

@Entity(name = "books")
public class Book {

    @Id
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "published_on")
    private Date publishedOn;

    @Column(name = "language")
    private String language;

    @Column(name = "is_hard_covered")
    private Boolean isHardCovered;

    @Column(name = "rating")
    private int rating;

    public Book(String title, String author, Date publishedOn, String language, Boolean isHardCovered, int rating) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPublishedOn(publishedOn);
        this.setLanguage(language);
        this.setHardCovered(isHardCovered);
        this.setRating(rating);
    }

    public Book() {
        super();
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        this.author = author;
    }

    public Date getPublishedOn() {
        return publishedOn;
    }

    private void setPublishedOn(Date publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getLanguage() {
        return language;
    }

    private void setLanguage(String language) {
        this.language = language;
    }

    public Boolean getHardCovered() {
        return isHardCovered;
    }

    private void setHardCovered(Boolean hardCovered) {
        isHardCovered = hardCovered;
    }

    public int getRating() {
        return rating;
    }

    private void setRating(int rating) {
        this.rating = rating;
    }
}
