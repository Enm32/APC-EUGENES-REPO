package com.example.progresscheckerforcbc;

import android.content.Context;

import com.example.progresscheckerforcbc.model.NotificationRequest;
import com.example.progresscheckerforcbc.model.NotificationResponse;
import com.example.progresscheckerforcbc.retrofit.add_rating_api;
import com.example.progresscheckerforcbc.retrofit.retrofit_service;

import java.security.KeyStore;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationHandler {
    private  String auth;
    private  String stuName;


    public NotificationHandler(String auth, String stuName) {
        this.auth = auth;
        this.stuName = stuName;
    }


//    public String getNotiftoken(){
//        retrofit_service rs=new retrofit_service();
//        add_rating_api ada=rs.getRetrofit().create(add_rating_api.class);
//
//        ada.getNotificationtoken(auth,stuName).enqueue(new Callback<NotificationResponse>() {
//            @Override
//            public void onResponse(Call<NotificationResponse> call, Response<NotificationResponse> response) {
//              String tok=response.body().getMessage();
//
//            }
//
//            @Override
//            public void onFailure(Call<NotificationResponse> call, Throwable throwable) {
//
//            }
//        });
//
//    }

    public void sendNotification(){
        retrofit_service rhs=new retrofit_service();
        add_rating_api ala=rhs.getRetrofit().create(add_rating_api.class);


        ala.getNotificationtoken(auth,stuName).enqueue(new Callback<NotificationResponse>() {
            @Override
            public void onResponse(Call<NotificationResponse> call, Response<NotificationResponse> response) {
             String token=response.body().getMessage();


                NotificationRequest hjklop=new NotificationRequest("New Rating","A new rating has been added","Latest rating",token);
                ala.sendNotification(hjklop).enqueue(new Callback<NotificationResponse>() {
                    @Override
                    public void onResponse(Call<NotificationResponse> call, Response<NotificationResponse> response) {

                    }

                    @Override
                    public void onFailure(Call<NotificationResponse> call, Throwable throwable) {

                    }
                });
            }

            @Override
            public void onFailure(Call<NotificationResponse> call, Throwable throwable) {

            }
        });



    }

}
