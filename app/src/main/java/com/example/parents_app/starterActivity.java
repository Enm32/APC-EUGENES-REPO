package com.example.parents_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class starterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Handler hn=new Handler();
//        hn.postDelayed(() -> {
//
//            SharedPreferences shred_preferences=getSharedPreferences("Status",MODE_PRIVATE);
//            String state=shred_preferences.getString("mode","");
//            if(!state.equals("verified")){
//                Intent i = new Intent(getApplicationContext(), otLogin.class);
//
//                startActivity(i);
//                finish();
//            }else{
//                Intent iio = new Intent(getApplicationContext(), MainActivity.class);
//
//                startActivity(iio);
//                finish();}
//
//        },2000);
        Intent iio = new Intent(getApplicationContext(), sign_upActivity.class);

                startActivity(iio);


    }
}