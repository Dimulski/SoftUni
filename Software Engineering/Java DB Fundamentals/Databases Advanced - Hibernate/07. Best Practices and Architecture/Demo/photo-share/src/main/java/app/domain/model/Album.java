package app.domain.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {

    private Integer id;
    private String name;
    private Color backgroundColor;
    private Boolean isPublic;
    private Set<AlbumRole> albumRoles;
    private Set<Picture> pictures;
    private Set<Tag> tags;

    public Album() {
        this.setAlbumRoles(new HashSet<>());
        this.setPictures(new HashSet<>());
        this.setTags(new HashSet<>());
    }

    @Id
    @Column(name = "album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Enumerated(value = EnumType.STRING)
    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    @Column(name = "is_public")
    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    public Set<AlbumRole> getAlbumRoles() {
        return albumRoles;
    }

    public void setAlbumRoles(Set<AlbumRole> albumRoles) {
        this.albumRoles = albumRoles;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "album_pictures",
            joinColumns = @JoinColumn(name = "picture_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id")
    )
    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "album_tags",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    public Set<Tag> getTags() {
        return tags;
    }

    public void setTags(Set<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return String.format("%s has %d pictures", this.getName(), this.getPictures().size());
    }

}
