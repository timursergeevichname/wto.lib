package wto.lib.service;

import okhttp3.OkHttpClient;
import wto.lib.Config;
import wto.lib.entity.fleet.*;
import wto.lib.parser.JAXBParser;

public class FleetService extends Servise {


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


    public AsyncFleetResponse infoFleet() throws AsyncFleetException {

        try {

            AsyncFleetResponse asyncFleetResponse = query(asyncFleetRequestJAXBParser, asyncFleetResponseJAXBParser, new AsyncFleetRequest(), AsyncFleetResponse.class, Config.asyncFleet);
            return asyncFleetResponse;


        } catch (Exception e) {

            throw new AsyncFleetException(e);

        }

    }

    public boolean createFleet() throws CreateFleetException {

        try {

            CreateFleetResponse createFleetResponse = query(createFleetRequestJAXBParser, createFleetResponseJAXBParser, new CreateFleetRequest(), CreateFleetResponse.class, Config.createFleet);

            if (createFleetResponse.getStatus().equals(CreateFleetResponse.Status.OK)) {

                return true;

            }

            return true;


        } catch (Exception e) {

            throw new CreateFleetException(e);

        }


    }

}
