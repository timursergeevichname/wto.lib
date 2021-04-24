package wto.lib.entity.statistic;

import wto.lib.entity.statistic.Statistics;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "tank-statistic-response")
public class TankStatisticResponse {

    @XmlElementWrapper
    @XmlElement(name = "statistics")
    private List<Statistics> statistics;

    public List<Statistics> getStatistics() {
        return statistics;
    }

    @Override
    public String toString() {
        return "TankStatisticResponse{" +
                "statistics=" + statistics +
                '}';
    }
}
