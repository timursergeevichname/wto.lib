package wto.lib.service;

import okhttp3.*;
import wto.lib.Config;
import wto.lib.parser.Parser;

import java.io.StringReader;
import java.io.StringWriter;

public abstract class Servise {

    OkHttpClient httpClient;

    public Servise(OkHttpClient okHttpClient) {

        this.httpClient = okHttpClient;

    }

    protected <Req, Resp> Resp query(Parser<Req> requestJAXBParser, Parser<Resp> responseJAXBParser, Req req, Class<Resp> clazz, String path) throws Exception {

        StringWriter stringWriter = new StringWriter();
        requestJAXBParser.saveObject(stringWriter, req);
        Request request = new Request.Builder()
                .url(Config.host + path)
                .header("Content-Type", "text/xml; charset=utf-8")
                .post(RequestBody.create(MediaType.parse("text/xml"), stringWriter.toString()))
                .build();



        Response response = httpClient.newCall(request).execute();
        return responseJAXBParser.getObject(new StringReader(response.body().string()), clazz);


    }


}
