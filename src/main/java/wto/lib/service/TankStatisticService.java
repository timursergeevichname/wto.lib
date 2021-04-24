package wto.lib.service;

import okhttp3.OkHttpClient;
import wto.lib.entity.statistic.TankStatisticRequest;
import wto.lib.entity.statistic.TankStatisticResponse;
import wto.lib.entity.statistic.TankStatisticsException;
import wto.lib.parser.JAXBParser;

public class TankStatisticService extends Servise {

    private final JAXBParser<TankStatisticRequest> requestJAXBParser;
    private final JAXBParser<TankStatisticResponse> responseJAXBParser;


    public TankStatisticService(OkHttpClient okHttpClient) {
        super(okHttpClient);
        requestJAXBParser = new JAXBParser<>();
        responseJAXBParser = new JAXBParser<>();
    }

    public TankStatisticResponse getStatistic(TankStatisticRequest tankStatisticRequest) throws TankStatisticsException {

        try {

            TankStatisticResponse tankStatisticResponse = query(requestJAXBParser, responseJAXBParser, tankStatisticRequest, TankStatisticResponse.class);
            return tankStatisticResponse;

        } catch (Exception e) {

            throw new TankStatisticsException(e);

        }


    }

}
