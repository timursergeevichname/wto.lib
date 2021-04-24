package wto.lib.entity.profile;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "client-profile-request")
public class ClientProfileRequest {

    @XmlAttribute(name = "user_id")
    private int userId;

    private ClientProfileRequest() {
    }

    @Override
    public String toString() {
        return "ClientProfileRequest{" +
                "userId=" + userId +
                '}';
    }

    public static final class Builder {

        ClientProfileRequest clientProfileRequest = new ClientProfileRequest();

        public Builder setUserId(int userId) {
            clientProfileRequest.userId = userId;
            return this;
        }

        public ClientProfileRequest build() {
            return clientProfileRequest;
        }

    }


}
