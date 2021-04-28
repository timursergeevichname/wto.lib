package wto.lib.service;

import okhttp3.OkHttpClient;
import wto.lib.Config;
import wto.lib.entity.fleet.CreateFleetRequest;
import wto.lib.entity.fleet.CreateFleetResponse;
import wto.lib.entity.rating.RatingRequest;
import wto.lib.entity.rating.RatingRequestException;
import wto.lib.entity.rating.RatingResponse;
import wto.lib.entity.rating.RatingType;
import wto.lib.parser.JAXBParser;

public class RatingService extends Servise{

    private final JAXBParser<RatingRequest> ratingRequestJAXBParser;
    private final JAXBParser<RatingResponse> ratingResponseJAXBParser;

    public RatingService(OkHttpClient okHttpClient) {
        super(okHttpClient);
        ratingRequestJAXBParser = new JAXBParser<>();
        ratingResponseJAXBParser = new JAXBParser<>();
    }

   public RatingResponse getRatingResponce(int position) throws RatingRequestException {

        RatingRequest ratingRequest = new RatingRequest.Builder()
                .setRatingType(RatingType.RATING_MY_POSITION)
                .setPosition(position)
                .build();

        try {
            return query(ratingRequestJAXBParser, ratingResponseJAXBParser, ratingRequest, RatingResponse.class, Config.ratingService);
        } catch (Exception e) {
            throw new RatingRequestException(e);
        }


    }

}
