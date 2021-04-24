package wto.lib.service;

import okhttp3.OkHttpClient;
import wto.lib.Config;
import wto.lib.entity.profile.ClientProfileException;
import wto.lib.entity.profile.ClientProfileRequest;
import wto.lib.entity.profile.ClientProfileResponse;
import wto.lib.parser.JAXBParser;

public class ClientProfileService extends Servise {

    private final JAXBParser<ClientProfileRequest> requestJAXBParser;
    private final JAXBParser<ClientProfileResponse> responseJAXBParser;

    public ClientProfileService(OkHttpClient okHttpClient) {
        super(okHttpClient);
        requestJAXBParser = new JAXBParser<>();
        responseJAXBParser = new JAXBParser<>();
    }

    public ClientProfileResponse getProfile(ClientProfileRequest clientProfileRequest) throws ClientProfileException {

        try {

            ClientProfileResponse clientProfileResponse = query(requestJAXBParser, responseJAXBParser, clientProfileRequest, ClientProfileResponse.class, Config.clientProfilePath);
            return clientProfileResponse;


        } catch (Exception e) {

            throw new ClientProfileException(e);

        }

    }

}
