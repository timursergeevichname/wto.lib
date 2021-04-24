package wto.lib.entity.auth;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "auth-request")
public final class AuthRequest {
    @XmlAttribute
    private AythType authType;

    @XmlAttribute
    private String login;

    @XmlAttribute
    private String password;

    @XmlAttribute
    private int version;

    private AuthRequest() {
    }

    @Override
    public String toString() {
        return "AuthRequest{" +
                "authType=" + authType +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", version=" + version +
                '}';
    }

    public final static class Builder {

        AuthRequest authRequest = new AuthRequest();

        public Builder setAuthType(AythType authType) {
            authRequest.authType = authType;
            return this;
        }

        public Builder setLogin(String login) {
            authRequest.login = login;
            return this;
        }

        public Builder setPassword(String password) {
            authRequest.password = password;
            return this;
        }

        public Builder setVersion(int version) {
            authRequest.version = version;
            return this;
        }

        public AuthRequest build() {
            return authRequest;
        }

    }

}



