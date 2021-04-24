package wto.lib.entity.auth;

import wto.lib.entity.Status;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "auth-response")
public class AuthResponse {

    @XmlAttribute(name = "user-id")
    private int userId;

    @XmlAttribute
    private Status status;

    public int getUserId() {
        return userId;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "AuthResponse{" +
                "userId=" + userId +
                ", status=" + status +
                '}';
    }

}
