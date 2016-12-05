package app.domain;

import javax.xml.bind.annotation.*;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "authors")
@XmlAccessorType(XmlAccessType.FIELD)
public class AuthorCollection {

    @XmlElement(name = "author")
    private Set<Author> authors;

    public AuthorCollection() {
        this.setAuthors(new HashSet<>());
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }
}
