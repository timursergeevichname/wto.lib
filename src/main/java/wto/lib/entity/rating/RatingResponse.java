package wto.lib.entity.rating;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "rating-exp-response")
public class RatingResponse {

    @XmlElementWrapper(name = "rating-unit")
    private List<Ratings> ratings;

    public List<Ratings> getRatings() {
        return ratings;
    }

    @Override
    public String toString() {
        return "RatingResponse{" +
                "ratings=" + ratings +
                '}';
    }
}
