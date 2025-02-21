package com.example.progresscheckerforcbc.retrofit;

import com.example.progresscheckerforcbc.model.NotificationRequest;
import com.example.progresscheckerforcbc.model.NotificationResponse;
import com.example.progresscheckerforcbc.model.add_rating_model;
import com.example.progresscheckerforcbc.model.rating_response;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface add_rating_api {
    @POST("/addRating")
    Call<rating_response> addRating(@Header("Authorization") String auth,@Body add_rating_model adl);
    @GET("/getNotifToken")
    Call<NotificationResponse> getNotificationtoken(@Header("Authorization") String auth,@Query("studentName") String studentName);

    @POST("/notification")
    Call<NotificationResponse> sendNotification(@Body NotificationRequest request);

}
