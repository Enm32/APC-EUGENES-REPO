package com.example.progresscheckerforcbc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Handler;

public class start_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

     //   setContentView(R.layout.activity_main);
Handler hn=new Handler();
hn.postDelayed(() -> {

    SharedPreferences shred_preferences=getSharedPreferences("Status",MODE_PRIVATE);
    String state=shred_preferences.getString("mode","");
    if(!state.equals("verified")){
        Intent i = new Intent(getApplicationContext(), signup.class);

        startActivity(i);
        finish();
    }else{
        Intent iio = new Intent(getApplicationContext(), MainActivity.class);

        startActivity(iio);
        finish();}

},2000);


            }

    }

