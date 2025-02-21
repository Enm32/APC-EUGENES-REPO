package com.example.progresscheckerforcbc.retrofit;

import com.example.progresscheckerforcbc.model.NotificationResponse;
import com.example.progresscheckerforcbc.model.students;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface getStudents_api {
    @GET("/getallStudents")
    Call<List<students>> getStudents();





}
