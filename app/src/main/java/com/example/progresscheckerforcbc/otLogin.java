package com.example.progresscheckerforcbc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.progresscheckerforcbc.model.otpResponse;
import com.example.progresscheckerforcbc.model.tokenresponse;
import com.example.progresscheckerforcbc.pp3_material.pp3activity;
import com.example.progresscheckerforcbc.retrofit.otp_verification;
import com.example.progresscheckerforcbc.retrofit.retrofit_service;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class otLogin extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_ot_login);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.login_main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

        try {
            Intent jkl=getIntent();
            String username=jkl.getStringExtra("T_name");
            String em=jkl.getStringExtra("T_email");
            EditText gh = findViewById(R.id.ec_edittext);
            Button a = findViewById(R.id.otpsend);
            Button b = findViewById(R.id.verifyotp);
            ProgressBar pBar=findViewById(R.id.pb_otp);

            CryptoManager nm=new CryptoManager(otLogin.this);


            retrofit_service us = new retrofit_service();
            otp_verification otp_api = us.getRetrofit().create(otp_verification.class);


            a.setOnClickListener(v -> {
                    pBar.setVisibility(View.VISIBLE);
                otp_api.sendOtp(em).enqueue(new Callback<otpResponse>() {
                    @Override
                    public void onResponse(Call<otpResponse> call, Response<otpResponse> response) {
                        pBar.setVisibility(View.GONE);
                        Toast.makeText(otLogin.this, response.body().getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<otpResponse> call, Throwable throwable) {
                        pBar.setVisibility(View.GONE);
                        Toast.makeText(otLogin.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        Logger.getLogger(otLogin.class.getName()).log(Level.SEVERE, "otp error", throwable);
                    }
                });
            });


            b.setOnClickListener(v -> {
                pBar.setVisibility(View.VISIBLE);
                otp_api.verifyOtp(gh.getText().toString()).enqueue(new Callback<otpResponse>() {
                    @Override
                    public void onResponse(Call<otpResponse> call, Response<otpResponse> response) {

                        pBar.setVisibility(View.GONE);
                        try {

                            if (Objects.equals(response.body().getMessage(), "verification failed")) {
                                Toast.makeText(otLogin.this, "wrong code", Toast.LENGTH_SHORT).show();
                            } else {
                                otp_api.token_gen(username).enqueue(new Callback<tokenresponse>() {
                                        @Override
                                        public void onResponse(Call<tokenresponse> call, Response<tokenresponse> response) {
                                            try {
                                                nm.encrypth(response.body().getToken(), nm.getKey());
                                                 //Toast.makeText(otLogin.this, response.body().getToken(), Toast.LENGTH_LONG).show();
                                            } catch (Exception e) {
                                                Toast.makeText(otLogin.this, e.getMessage(), Toast.LENGTH_LONG).show();
                                                Logger.getLogger(otLogin.class.getName()).log(Level.SEVERE,"tokenrt",e);
                                            }
                                        }

                                        @Override
                                        public void onFailure(Call<tokenresponse> call, Throwable throwable) {
                                            pBar.setVisibility(View.GONE);
                                            Toast.makeText(otLogin.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    });

                    SharedPreferences sharedpreferences = getSharedPreferences("Status", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedpreferences.edit();
                    editor.putString("mode", "verified");
                    editor.apply();


                    moveToSecondary();
                            }
                        } catch (Exception e) {
                            pBar.setVisibility(View.GONE);
                            Toast.makeText(otLogin.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            Logger.getLogger(otLogin.class.getName()).log(Level.SEVERE, "tgj", e.getMessage());
                        }


                    }

                    @Override
                    public void onFailure(Call<otpResponse> call, Throwable throwable) {
                        pBar.setVisibility(View.GONE);
                        Toast.makeText(otLogin.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        Logger.getLogger(otLogin.class.getName()).log(Level.SEVERE, "verification error", throwable);
                    }
                });


             });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public void moveToSecondary(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}