package wto.lib.service;

import okhttp3.*;
import wto.lib.Config;
import wto.lib.entity.profile.ClientProfileException;
import wto.lib.entity.profile.ClientProfileRequest;
import wto.lib.entity.profile.ClientProfileResponse;
import wto.lib.parser.JAXBParser;

import java.io.StringReader;
import java.io.StringWriter;

public class ClientProfileService extends Servise{

    private final JAXBParser<ClientProfileRequest> requestJAXBParser;
    private final JAXBParser<ClientProfileResponse> responseJAXBParser;

    public ClientProfileService(OkHttpClient okHttpClient) {
        super(okHttpClient);
        requestJAXBParser = new JAXBParser<>();
        responseJAXBParser = new JAXBParser<>();
    }

    public ClientProfileResponse getProfile(ClientProfileRequest clientProfileRequest) throws ClientProfileException {

        StringWriter stringWriter = new StringWriter();

        try {
            requestJAXBParser.saveObject(stringWriter,clientProfileRequest);
            Request request = new Request.Builder()
                    .url(Config.host + Config.clientProfilePath)
                    .header("Content-Type", "text/xml; charset=utf-8")
                    .post(RequestBody.create(MediaType.parse("text/xml"), stringWriter.toString()))
                    .build();

            Response response = httpClient.newCall(request).execute();
            ClientProfileResponse clientProfileResponse = responseJAXBParser.getObject(new StringReader(response.body().string()), ClientProfileResponse.class);
            return clientProfileResponse;



        } catch (Exception e) {

            throw new ClientProfileException(e);

        }

    }

}
