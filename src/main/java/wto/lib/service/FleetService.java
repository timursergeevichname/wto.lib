package wto.lib.service;

import okhttp3.*;
import wto.lib.Config;
import wto.lib.entity.*;
import wto.lib.parser.JAXBParser;

import java.io.StringReader;
import java.io.StringWriter;

public class FleetService extends Servise{


    private final JAXBParser<CreateFleetRequest> createFleetRequestJAXBParser;
    private final JAXBParser<CreateFleetResponse> createFleetResponseJAXBParser;

    private final JAXBParser<AsyncFleetRequest> asyncFleetRequestJAXBParser;
    private final JAXBParser<AsyncFleetResponse> asyncFleetResponseJAXBParser;




    public FleetService(OkHttpClient okHttpClient) {

        super(okHttpClient);
        createFleetRequestJAXBParser = new JAXBParser<>();
        createFleetResponseJAXBParser = new JAXBParser<>();
        asyncFleetRequestJAXBParser = new JAXBParser<>();
        asyncFleetResponseJAXBParser = new JAXBParser<>();

    }


    public AsyncFleetResponse infoFleet() throws AsyncFleetException{

        StringWriter stringWriter = new StringWriter();

        try {
            asyncFleetRequestJAXBParser.saveObject(stringWriter,new AsyncFleetRequest(true));
            Request request = new Request.Builder()
                    .url(Config.host + Config.asyncFleet)
                    .header("Content-Type", "text/xml; charset=utf-8")
                    .post(RequestBody.create(MediaType.parse("text/xml"), stringWriter.toString()))
                    .build();

            Response response = httpClient.newCall(request).execute();
            AsyncFleetResponse asyncFleetResponse = asyncFleetResponseJAXBParser.getObject(new StringReader(response.body().string()), AsyncFleetResponse.class);

            return asyncFleetResponse;



        } catch (Exception e) {

            throw new AsyncFleetException(e);

        }

    }

    public boolean createFleet() throws CreateFleetException {

        StringWriter stringWriter = new StringWriter();

        try {
            createFleetRequestJAXBParser.saveObject(stringWriter,new CreateFleetRequest());
            Request request = new Request.Builder()
                    .url(Config.host + Config.createFleet)
                    .header("Content-Type", "text/xml; charset=utf-8")
                    .post(RequestBody.create(MediaType.parse("text/xml"), stringWriter.toString()))
                    .build();

            Response response = httpClient.newCall(request).execute();
           CreateFleetResponse createFleetResponse = createFleetResponseJAXBParser.getObject(new StringReader(response.body().string()), CreateFleetResponse.class);
           if(createFleetResponse.getStatus().equals(CreateFleetResponse.Status.OK)){

               return true;

           }



        } catch (Exception e) {

            throw new CreateFleetException(e);

        }

        return false;


    }

}
