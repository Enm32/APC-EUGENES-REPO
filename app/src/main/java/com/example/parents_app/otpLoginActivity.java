package com.example.parents_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.parents_app.models.otpResponse;
import com.example.parents_app.models.tokenresponse;
import com.example.parents_app.retrofit.getRatings;
import com.example.parents_app.retrofit.retrofit_service;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class otpLoginActivity extends AppCompatActivity {
    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_otp_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        try {
            Button kng=findViewById(R.id.btn_continue);
            TextView vg=findViewById(R.id.tv_resend_code);
            EditText gh=findViewById(R.id.code);
            ProgressBar bn=findViewById(R.id.pb_cv);

            CryptoManager nm=new CryptoManager(otpLoginActivity.this);

            String em= getIntent().getStringExtra("email");
            String nml=getIntent().getStringExtra("nm");

            retrofit_service rks = new retrofit_service();
            getRatings otp=rks.getRetrofit().create(getRatings.class);
            bn.setVisibility(View.VISIBLE);

            otp.sendOtp(em).enqueue(new Callback<otpResponse>() {

                @Override
                public void onResponse(Call<otpResponse> call, Response<otpResponse> response) {
                    bn.setVisibility(View.GONE);
                    Toast.makeText(otpLoginActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                    Toast.makeText(otpLoginActivity.this, nml, Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(Call<otpResponse> call, Throwable throwable) {
                    bn.setVisibility(View.GONE);
                    Toast.makeText(otpLoginActivity.this, throwable.getMessage(), Toast.LENGTH_LONG).show();
                }
            });

            kng.setOnClickListener(v -> {
                String code = gh.getText().toString();
               // gh.setText(" ");
                bn.setVisibility(View.VISIBLE);
                otp.verifyOtp(code).enqueue(new Callback<otpResponse>() {
                @Override
                public void onResponse(Call<otpResponse> call, Response<otpResponse> response) {

                try {
                    if (Objects.equals(response.body().getMessage(), "verification failed")) {
                        Toast.makeText(otpLoginActivity.this, "wrong code", Toast.LENGTH_SHORT).show();
                    } else {

                      otp.token_gen(nml).enqueue(new Callback<tokenresponse>() {
                          @Override
                          public void onResponse(Call<tokenresponse> call, Response<tokenresponse> response) {
                              bn.setVisibility(View.GONE);
                              try {
                                  nm.encrypth(response.body().getToken(), nm.getKey());
                                 // Toast.makeText(otpLoginActivity.this, response.body().getToken(), Toast.LENGTH_SHORT).show();
                              } catch (Exception e) {
                                  Toast.makeText(otpLoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                  LOGGER.log(Level.SEVERE,"token error",e);
                              }
                          }

                          @Override
                          public void onFailure(Call<tokenresponse> call, Throwable throwable) {
                              bn.setVisibility(View.GONE);
                              Toast.makeText(otpLoginActivity.this, "token_error", Toast.LENGTH_SHORT).show();
                          }
                      });

                        SharedPreferences sharedpreferences = getSharedPreferences("Important_info", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("Status", "verified");
                        editor.apply();
                        Intent kl = new Intent(getApplicationContext(), homeActivity.class);
                        startActivity(kl);

                    }
                }catch (Exception e){
                    Toast.makeText(otpLoginActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    bn.setVisibility(View.GONE);
                    Logger.getLogger(otpLoginActivity.class.getName()).log(Level.SEVERE, "tgj", e.getMessage());
                }
                }
                @Override
                public void onFailure(Call<otpResponse> call, Throwable throwable) {
                    bn.setVisibility(View.GONE);
                    Toast.makeText(otpLoginActivity.this, "wrong code", Toast.LENGTH_SHORT).show();
                    Logger.getLogger(otpLoginActivity.class.getName()).log(Level.SEVERE, "tj", throwable);
                }
            });

            });

            vg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    bn.setVisibility(View.VISIBLE);
                    otp.sendOtp(em).enqueue(new Callback<otpResponse>() {
                        @Override
                        public void onResponse(Call<otpResponse> call, Response<otpResponse> response) {
                            bn.setVisibility(View.GONE);
                            Toast.makeText(otpLoginActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
                        }

                        @Override
                        public void onFailure(Call<otpResponse> call, Throwable throwable) {
                            bn.setVisibility(View.GONE);
                        }
                    });
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}