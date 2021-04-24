package wto.lib.service;

import okhttp3.*;
import wto.lib.Config;
import wto.lib.parser.JAXBParser;

import java.io.StringReader;
import java.io.StringWriter;

public abstract class Servise {

    OkHttpClient httpClient;

    public Servise(OkHttpClient okHttpClient) {

        this.httpClient = okHttpClient;

    }

    protected <Req, Resp> Resp query(JAXBParser<Req> requestJAXBParser, JAXBParser<Resp> responseJAXBParser, Req req, Class<Resp> clazz) throws Exception {

        StringWriter stringWriter = new StringWriter();
        requestJAXBParser.saveObject(stringWriter, req);
        Request request = new Request.Builder()
                .url(Config.host + Config.authPath)
                .header("Content-Type", "text/xml; charset=utf-8")
                .post(RequestBody.create(MediaType.parse("text/xml"), stringWriter.toString()))
                .build();

        Response response = httpClient.newCall(request).execute();
        Resp resp = responseJAXBParser.getObject(new StringReader(response.body().string()), clazz);
        return resp;


    }


}
