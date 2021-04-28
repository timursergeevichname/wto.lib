package wto.lib.entity.rating;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "rating-request")
public class RatingRequest {

    @XmlAttribute
    RatingType ratingType;

    @XmlElement
    int position;

    private RatingRequest(){}

    public static final class Builder{

       private RatingRequest ratingRequest = new RatingRequest();

       public Builder setRatingType(RatingType ratingType){

            ratingRequest.ratingType = ratingType;
            return this;

        }

      public   Builder setPosition(int position){

            ratingRequest.position = position;
            return this;

        }

       public RatingRequest build(){

            return ratingRequest;

        }

    }

    @Override
    public String toString() {
        return "RatingRequest{" +
                "ratingType=" + ratingType +
                ", position=" + position +
                '}';
    }
}
