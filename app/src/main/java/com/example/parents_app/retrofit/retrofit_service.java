package com.example.parents_app.retrofit;

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
                .baseUrl("https://apc-eugenes-repo.onrender.com")
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
    }
}
