package com.example.e_commerce_app.data.RetrofitClient;

import com.example.e_commerce_app.data.ApiService.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.OffsetDateTime;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public final static String BASE_URL = "https://api.escuelajs.co/";
    private static ApiService getPlatziApiService = null;

    public static ApiService getGetPlatziApiService() {
        if (getPlatziApiService == null) {
            getPlatziApiService = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                            .registerTypeAdapter(OffsetDateTime.class, new OffsetDateTimeDeserializer())
                            .create()))
                    .build()
                    .create(ApiService.class);
        }
        return getPlatziApiService;
    }
}
