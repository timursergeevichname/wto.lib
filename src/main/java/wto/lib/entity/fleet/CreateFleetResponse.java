package wto.lib.entity.fleet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "create-fleet-response")
public class CreateFleetResponse {

    @XmlAttribute
    private Status status;

    public Status getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "CreateFleetResponse{" +
                "status=" + status +
                '}';
    }

    public enum Status{

        OK

    }

}
