package com.example.alexander.kurs_4_1.common;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alexander on 27.12.2016.
 */

public class NetworkManager {
    private static ApiService service;

    public static void init(){
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://sokolov1.esy.es/web/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(builder.build())
                .build();

        service = retrofit.create(ApiService.class);
    }

    public static ApiService getInstance(){
        if(service == null)
            init();

        return service;
    }
}
