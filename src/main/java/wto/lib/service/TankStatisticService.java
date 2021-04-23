package wto.lib.service;

import okhttp3.*;
import wto.lib.Config;
import wto.lib.entity.Statistics;
import wto.lib.entity.TankStatisticRequest;
import wto.lib.entity.TankStatisticResponse;
import wto.lib.entity.TankStatisticsException;
import wto.lib.parser.JAXBParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class TankStatisticService {

    private OkHttpClient httpClient;
    private JAXBParser<TankStatisticRequest> requestJAXBParser;
    private JAXBParser<TankStatisticResponse> responseJAXBParser;


    public TankStatisticService(OkHttpClient okHttpClient){
        httpClient = okHttpClient;
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
