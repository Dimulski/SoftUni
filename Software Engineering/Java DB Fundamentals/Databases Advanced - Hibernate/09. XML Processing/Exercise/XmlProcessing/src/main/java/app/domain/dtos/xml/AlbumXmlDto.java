package app.domain.dtos.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "album")
@XmlAccessorType(XmlAccessType.FIELD)
public class AlbumXmlDto implements Serializable {

    @XmlAttribute(name = "title")
    private String title;

    @XmlElement(name = "song")
    private Set<SongXmlDto> songs;

    public AlbumXmlDto() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<SongXmlDto> getSongs() {
        if (this.songs == null) {
            this.setSongs(new HashSet<>());
        }

        return songs;
    }

    public void setSongs(Set<SongXmlDto> songs) {
        this.songs = songs;
    }

    @Override
    public String toString() {
        return "AlbumXmlDto{" +
                "title='" + title + '\'' +
                ", songs=" + songs +
                '}';
    }
}
