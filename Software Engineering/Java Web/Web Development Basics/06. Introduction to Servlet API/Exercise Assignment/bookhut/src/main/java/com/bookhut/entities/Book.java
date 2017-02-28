package com.bookhut.entities;

import java.util.Date;
import java.util.Random;

public class Book {

    private long id;

    private String title;

    private String author;

    private int pages;

    private Date creationDate;

    public Book() {
        this.creationDate = new Date();
    }

    public Book(String title, String author, int pages) {
        this();
        this.title = title;
        this.author = author;
        this.pages = pages;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
