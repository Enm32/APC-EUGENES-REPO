package com.example.progresscheckerforcbc.retrofit;


import com.example.progresscheckerforcbc.model.signUpresponse;
import com.example.progresscheckerforcbc.model.teacher_sign_up;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface new_teacher {
    @POST("/addTeacher")
    Call<signUpresponse> teacher_signup(@Body teacher_sign_up tsu);
}
