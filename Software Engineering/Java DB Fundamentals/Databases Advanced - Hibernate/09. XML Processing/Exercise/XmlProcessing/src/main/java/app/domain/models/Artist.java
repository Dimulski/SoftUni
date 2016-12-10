package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Artist implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private String name;

    @OneToMany(mappedBy = "artist", targetEntity = Album.class)
    private Set<Album> albums;

    public Artist() {
        super();
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

    public Set<Album> getAlbums() {
        if (this.albums == null) {
            this.setAlbums(new HashSet<>());
        }

        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }
}
