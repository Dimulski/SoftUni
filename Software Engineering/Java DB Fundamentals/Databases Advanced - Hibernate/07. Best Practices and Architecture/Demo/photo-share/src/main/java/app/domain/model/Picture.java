package app.domain.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pictures")
public class Picture {
    private Integer id;
    private String Title;
    private String Caption;
    private String Path;
    private Set<Album> albums;

    @Id
    @Column(name = "picture_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "title")
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @Column(name = "caption")
    public String getCaption() {
        return Caption;
    }

    public void setCaption(String caption) {
        Caption = caption;
    }

    @Column(name = "path")
    public String getPath() {
        return Path;
    }

    public void setPath(String path) {
        Path = path;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "pictures")
    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getTitle(), this.getCaption() != null ? this.getCaption() : "");
    }
}
