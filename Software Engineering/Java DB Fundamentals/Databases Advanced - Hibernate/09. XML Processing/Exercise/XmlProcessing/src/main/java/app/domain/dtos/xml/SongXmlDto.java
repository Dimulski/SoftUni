package app.domain.dtos.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement(name = "song")
@XmlAccessorType(XmlAccessType.FIELD)
public class SongXmlDto implements Serializable {

    @XmlAttribute(name = "title")
    private String title;

    @XmlAttribute(name = "length")
    private String length;

    public SongXmlDto() {
        super();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
