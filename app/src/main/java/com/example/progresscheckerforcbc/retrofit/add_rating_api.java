package com.example.progresscheckerforcbc.retrofit;

import com.example.progresscheckerforcbc.model.add_rating_model;
import com.example.progresscheckerforcbc.model.rating_response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface add_rating_api {
    @POST("/addRating")
    Call<rating_response> addRating(@Header("Authorization") String auth,@Body add_rating_model adl);
}
