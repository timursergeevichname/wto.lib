package wto.lib.service;

import okhttp3.*;
import wto.lib.Config;
import wto.lib.entity.AuthRequest;
import wto.lib.entity.AuthResponse;
import wto.lib.entity.AuthServiceException;
import wto.lib.parser.JAXBParser;

import java.io.StringReader;
import java.io.StringWriter;

public class AuthService {

    private OkHttpClient httpClient;
    private JAXBParser<AuthRequest> requestJAXBParser;
    private JAXBParser<AuthResponse> responseJAXBParser;


    public AuthService(OkHttpClient okHttpClient){
        httpClient = okHttpClient;
        requestJAXBParser = new JAXBParser<>();
        responseJAXBParser = new JAXBParser<>();
    }

    public AuthResponse auth(AuthRequest authRequest) throws AuthServiceException {

        StringWriter stringWriter = new StringWriter();
        try {
            requestJAXBParser.saveObject(stringWriter, authRequest);
            Request request = new Request.Builder()
                    .url(Config.host + Config.authPath)
                    .header("Content-Type", "text/xml; charset=utf-8")
                    .post(RequestBody.create(MediaType.parse("text/xml"), stringWriter.toString()))
                    .build();

            Response response = httpClient.newCall(request).execute();
            AuthResponse authResponse =  responseJAXBParser.getObject(new StringReader(response.body().string()), AuthResponse.class);
            return authResponse;

        }catch (Exception e){
            throw new AuthServiceException(e);
        }



    }


}