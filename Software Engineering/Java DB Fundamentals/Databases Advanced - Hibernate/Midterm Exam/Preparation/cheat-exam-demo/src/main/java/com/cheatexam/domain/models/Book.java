package com.cheatexam.domain.models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.xml.bind.annotation.*;


@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "books")
public class Book {

    @XmlAttribute(name = "id")
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @XmlElement(name = "name")
    @Expose
    @Column(name = "name")
    private String name;

    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    public Book() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}

