package com.example.progresscheckerforcbc;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.progresscheckerforcbc.model.otpResponse;
import com.example.progresscheckerforcbc.retrofit.otp_verification;
import com.example.progresscheckerforcbc.retrofit.retrofit_service;

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
            EditText gh = findViewById(R.id.ec_edittext);
            Button a = findViewById(R.id.otpsend);
            Button b = findViewById(R.id.verifyotp);

            retrofit_service us = new retrofit_service();
            otp_verification otp_api = us.getRetrofit().create(otp_verification.class);


            a.setOnClickListener(v -> {
                String em = gh.getText().toString();
                gh.setText(" ");
                otp_api.sendOtp(em).enqueue(new Callback<otpResponse>() {
                    @Override
                    public void onResponse(Call<otpResponse> call, Response<otpResponse> response) {
                        Toast.makeText(otLogin.this, response.body().getMessage().toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<otpResponse> call, Throwable throwable) {
                        Toast.makeText(otLogin.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                        Logger.getLogger(otLogin.class.getName()).log(Level.SEVERE, "otp error", throwable);
                    }
                });
            });
           b.setOnClickListener(v -> {
//                String code = gh.getText().toString();
//                otp_api.verifyOtp(code).enqueue(new Callback<otpResponse>() {
//                    @Override
//                    public void onResponse(Call<otpResponse> call, Response<otpResponse> response) {
//                        //Toast.makeText(otLogin.this, response.body().getMessage().toString(), Toast.LENGTH_SHORT).show();
//                        SharedPreferences sharedpreferences = getSharedPreferences("Status", MODE_PRIVATE);
//                        SharedPreferences.Editor editor = sharedpreferences.edit();
//                        editor.putString("mode", "verified");
//                        editor.apply();
//
//
//                        moveToSecondary();
//                    }
//
//                    @Override
//                    public void onFailure(Call<otpResponse> call, Throwable throwable) {
//                        Toast.makeText(otLogin.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
//                        Logger.getLogger(otLogin.class.getName()).log(Level.SEVERE, "otp jerror", throwable);
//                    }
//                });
               //Toast.makeText(otLogin.this, response.body().getMessage().toString(), Toast.LENGTH_SHORT).show();
               SharedPreferences sharedpreferences = getSharedPreferences("Status", MODE_PRIVATE);
               SharedPreferences.Editor editor = sharedpreferences.edit();
               editor.putString("mode", "verified");
               editor.apply();


               moveToSecondary();

            });










    }

    public void moveToSecondary(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}