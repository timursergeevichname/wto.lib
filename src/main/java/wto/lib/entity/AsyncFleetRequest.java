package wto.lib.entity;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "async-fleet-request")
public class AsyncFleetRequest {

    @XmlElement
    private boolean forcedLoad = false;

    public AsyncFleetRequest(boolean forcedLoad){

        this.forcedLoad = forcedLoad;

    }

    public AsyncFleetRequest(){

    }


    public boolean isForcedLoad() {
        return forcedLoad;
    }

    @Override
    public String toString() {
        return "AsyncFleetRequest{" +
                "forcedLoad=" + forcedLoad +
                '}';
    }
}
