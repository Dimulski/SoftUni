package bookhut.entities;

import java.util.Date;

public class Book {

    private long id;

    private String title;

    private String author;

    private int pages;

    private Date creationDate;

    public Book() {
    }

    public Book(String title, String author, int pages, Date creationDate) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPages(pages);
        this.setCreationDate(creationDate);
    }

    public long getId() {
        return id;
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

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
