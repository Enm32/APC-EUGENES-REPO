package com.example.parents_app.retrofit;

import com.example.parents_app.models.otpResponse;
import com.example.parents_app.models.ratings;
import com.example.parents_app.models.signUpresponse;
import com.example.parents_app.models.studentSignup;
import com.example.parents_app.models.tokenresponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface getRatings {
    @GET("/get_rate")
    Call<List<ratings>> get_ratings(@Header("Authorization") String auth, @Query("subj") String sub, @Query("stud") String stud);

    @POST("/addStudent")
    Call<signUpresponse> sign_up(@Body studentSignup ss);

    @POST("/send_otp")
    Call<otpResponse> sendOtp(@Query("email") String email);

    @POST("/verify_otp")
    Call<otpResponse> verifyOtp(@Query("code") String code);

    @POST("/auth/get_token")
    Call<tokenresponse> token_gen(@Query("username") String username);
}
