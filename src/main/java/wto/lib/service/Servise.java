package wto.lib.service;

import okhttp3.OkHttpClient;

public abstract class Servise {

    OkHttpClient httpClient;

    public Servise(OkHttpClient okHttpClient){

        this.httpClient = okHttpClient;

    }



}
