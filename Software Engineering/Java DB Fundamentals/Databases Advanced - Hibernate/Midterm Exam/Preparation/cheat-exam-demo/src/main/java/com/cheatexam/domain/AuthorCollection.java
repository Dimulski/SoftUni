package com.cheatexam.domain;


import com.cheatexam.domain.models.Author;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "authors")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorCollection {

    @XmlElement(name = "author")
    private List<Author> authors;

    public AuthorCollection() {
        this.setAuthors(new ArrayList<>());
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }
}