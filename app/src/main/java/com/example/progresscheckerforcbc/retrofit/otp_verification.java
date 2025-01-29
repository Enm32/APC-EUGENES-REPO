package com.example.progresscheckerforcbc.retrofit;

import com.example.progresscheckerforcbc.model.otpResponse;
import com.example.progresscheckerforcbc.model.tokenresponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface otp_verification {

    @POST("/send_otp")
    Call<otpResponse> sendOtp(@Query("email") String email);

    @POST("/verify_otp")
     Call<otpResponse> verifyOtp(@Query("code") String code);
    @POST("/auth/get_token")
    Call<tokenresponse> token_gen(@Query("username") String username);
}
