package wto.lib.entity.rating;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ratings")
public class Ratings {

    @XmlAttribute
    int position;

    @XmlAttribute(name = "ct")
    String clanTag;

    @XmlAttribute(name = "l")
    String userName;

    @XmlAttribute(name = "id")
    int userId;

    public int getPosition() {
        return position;
    }

    public String getClanTag() {
        return clanTag;
    }

    public String getUserName() {
        return userName;
    }

    public int getUserId() {
        return userId;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "position=" + position +
                ", clanTag='" + clanTag + '\'' +
                ", userName='" + userName + '\'' +
                ", userId=" + userId +
                '}';
    }
}
