package wto.lib.entity.fleet;

import wto.lib.entity.Status;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "async-fleet-response")
public class AsyncFleetResponse {

    @XmlAttribute(name = "status")
    private Status status;

    @XmlElement(name = "fleet")
    private Fleet fleet;

    public Fleet getFleet() {
        return fleet;
    }

    public Status getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "AsyncFleetResponse{" +
                "status=" + status +
                ", fleet=" + fleet +
                '}';
    }
}
