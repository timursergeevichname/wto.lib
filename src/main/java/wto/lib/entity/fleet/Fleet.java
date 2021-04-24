package wto.lib.entity.fleet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "fleet")
public class Fleet {

    @XmlElement
    private int id;

    @XmlElement(name = "ownid")
    private int createUserID;

    @XmlElement(name = "ownl")
    private String createUserLogin;

    @XmlElement(name = "cd")
    private Date createDate;

    @XmlElement(name = "od")
    private Date endDate;

    public int getId() {
        return id;
    }

    public int getCreateUserID() {
        return createUserID;
    }

    public String getCreateUserLogin() {
        return createUserLogin;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    @Override
    public String toString() {
        return "Fleet{" +
                "id=" + id +
                ", createUserID=" + createUserID +
                ", createUserLogin='" + createUserLogin + '\'' +
                ", createDate=" + createDate +
                ", endDate=" + endDate +
                '}';
    }
}
