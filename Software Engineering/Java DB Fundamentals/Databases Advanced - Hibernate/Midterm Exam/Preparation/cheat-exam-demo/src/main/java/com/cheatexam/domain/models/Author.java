package com.cheatexam.domain.models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "author")
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "authors")
public class Author {

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

    @XmlElementWrapper(name = "books")
    @XmlElement(name = "book")
    @Expose
    @OneToMany(mappedBy = "author", targetEntity = Book.class, cascade = CascadeType.ALL)
    private Set<Book> books;

    public Author() {
        this.setBooks(new HashSet<>());
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

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void addBook(Book book){
        this.getBooks().add(book);
    }

    public void deleteBook(Book book){
        this.getBooks().remove(book);
    }
}

