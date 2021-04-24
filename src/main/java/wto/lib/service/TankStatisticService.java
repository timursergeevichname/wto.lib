package wto.lib.service;

import okhttp3.*;
import wto.lib.Config;
import wto.lib.entity.statistic.TankStatisticRequest;
import wto.lib.entity.statistic.TankStatisticResponse;
import wto.lib.entity.statistic.TankStatisticsException;
import wto.lib.parser.JAXBParser;

import java.io.StringReader;
import java.io.StringWriter;

public class TankStatisticService extends Servise{

    private final JAXBParser<TankStatisticRequest> requestJAXBParser;
    private final JAXBParser<TankStatisticResponse> responseJAXBParser;


    public TankStatisticService(OkHttpClient okHttpClient){
        super(okHttpClient);
        requestJAXBParser = new JAXBParser<>();
        responseJAXBParser = new JAXBParser<>();
    }

    public TankStatisticResponse getStatistic(TankStatisticRequest tankStatisticRequest) throws TankStatisticsException {

        StringWriter stringWriter = new StringWriter();

        try {
            requestJAXBParser.saveObject(stringWriter,tankStatisticRequest);
            Request request = new Request.Builder()
                    .url(Config.host + Config.tankStatisticPath)
                    .header("Content-Type", "text/xml; charset=utf-8")
                    .post(RequestBody.create(MediaType.parse("text/xml"), stringWriter.toString()))
                    .build();

            Response response = httpClient.newCall(request).execute();
            TankStatisticResponse tankStatisticResponse = responseJAXBParser.getObject(new StringReader(response.body().string()), TankStatisticResponse.class);
            return tankStatisticResponse;



        } catch (Exception e) {

            throw new TankStatisticsException(e);

        }


    }

}
