package com.example.progresscheckerforcbc.retrofit;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit_service {
    private Retrofit retrofit;

    public retrofit_service() {
        startRetrofit();
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }
    private void  startRetrofit(){
        retrofit= new Retrofit.Builder()
                .baseUrl("http://192.168.38.17:8080")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
}
