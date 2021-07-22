package com.ssh.sustain.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ssh.sustain.api.service.SampleAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroClient {
    private static final String BASE_URL = "http://localhost:753/";

    public static SampleAPI getSampleService() {
        return getInstance().create(SampleAPI.class);
    }

    private static Retrofit getInstance() {
        Gson gson = new GsonBuilder().setLenient().create();
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }
}
