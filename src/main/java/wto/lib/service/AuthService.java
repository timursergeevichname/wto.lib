package wto.lib.service;

import okhttp3.OkHttpClient;
import wto.lib.entity.auth.AuthRequest;
import wto.lib.entity.auth.AuthResponse;
import wto.lib.entity.auth.AuthServiceException;
import wto.lib.parser.JAXBParser;

public class AuthService extends Servise {

    private final JAXBParser<AuthRequest> requestJAXBParser;
    private final JAXBParser<AuthResponse> responseJAXBParser;


    public AuthService(OkHttpClient okHttpClient) {
        super(okHttpClient);
        requestJAXBParser = new JAXBParser<>();
        responseJAXBParser = new JAXBParser<>();
    }

    public AuthResponse auth(AuthRequest authRequest) throws AuthServiceException {

        try {

            AuthResponse authResponse = query(requestJAXBParser, responseJAXBParser, authRequest, AuthResponse.class);
            return authResponse;

        } catch (Exception e) {
            throw new AuthServiceException(e);
        }


    }


}