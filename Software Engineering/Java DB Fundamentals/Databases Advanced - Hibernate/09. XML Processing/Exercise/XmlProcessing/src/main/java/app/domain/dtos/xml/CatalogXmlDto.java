package app.domain.dtos.xml;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@XmlRootElement(name = "catalog")
@XmlAccessorType(XmlAccessType.FIELD)
public class CatalogXmlDto implements Serializable {

    @XmlElementWrapper(name = "albums")
    @XmlElement(name = "album")
    private Set<AlbumXmlDto> albums;

    public CatalogXmlDto() {
        super();
    }

    public Set<AlbumXmlDto> getAlbums() {
        if (this.albums == null) {
            this.setAlbums(new HashSet<>());
        }

        return albums;
    }

    public void setAlbums(Set<AlbumXmlDto> albums) {
        this.albums = albums;
    }
}
