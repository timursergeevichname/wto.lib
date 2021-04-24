package wto.lib.entity.statistic;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tank-statistic-request")
public final class TankStatisticRequest {

    @XmlAttribute
    private int clientId;

    private TankStatisticRequest(){}

    @Override
    public String toString() {
        return "TankStatisticRequest{" +
                "clientId=" + clientId +
                '}';
    }

    public static final class Builder{

        TankStatisticRequest tankStatisticRequest = new TankStatisticRequest();

        public Builder setClientId(int clientId){
            tankStatisticRequest.clientId = clientId;
            return this;
        }

        public TankStatisticRequest build(){
            return tankStatisticRequest;
        }

    }

}
