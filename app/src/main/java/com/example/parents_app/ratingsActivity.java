package com.example.parents_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parents_app.models.ratings;
import com.example.parents_app.retrofit.getRatings;
import com.example.parents_app.retrofit.retrofit_service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ratingsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ratings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
//        Intent intent = getIntent();
//        String strn = intent.getStringExtra("student_name");
        try {


            RecyclerView rv = findViewById(R.id.ar_rv);

            CryptoManager mnjk=new CryptoManager(ratingsActivity.this);

            SharedPreferences hn=getSharedPreferences("mytok",MODE_PRIVATE);
            String tok= hn.getString("encryptedmessage","");


            retrofit_service rfs = new retrofit_service();
            getRatings gra = rfs.getRetrofit().create(getRatings.class);
            gra.get_ratings( "Bearer " + mnjk.decrypt_m(mnjk.getKey()),"mathPp2", "martin").enqueue(new Callback<List<ratings>>() {
                @Override
                public void onResponse(Call<List<ratings>> call, Response<List<ratings>> response) {
                    try {
                        List<ratings> hn=new ArrayList<>();
                        hn=response.body();
                        ratings_adapter rad = new ratings_adapter(ratingsActivity.this,hn);
                        rv.setAdapter(rad);
                        rv.setLayoutManager(new LinearLayoutManager(ratingsActivity.this));
                    } catch (Exception e) {
                        Toast.makeText(ratingsActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                    //Toast.makeText(ratingsActivity.this, response.body().get(0).getRating(), Toast.LENGTH_LONG).show();

                }

                @Override
                public void onFailure(Call<List<ratings>> call, Throwable throwable) {
                    Toast.makeText(ratingsActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    Logger.getLogger(ratingsActivity.class.getName()).log(Level.SEVERE, "tuff", throwable);
                }
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}

//            retrofit_service rfs = new retrofit_service();
//            getStudents_api gsa = rfs.getRetrofit().create(getStudents_api.class);
//            gsa.getStudents().enqueue(new Callback<List<students>>() {
//                @Override
//                public void onResponse(Call<List<students>> call, Response<List<students>> response) {
//                    s_names = response.body();
//                    rv_adapter adapter = new rv_adapter(pp2activity.this);
//                    adapter.setSn(s_names);
//                    cr.setAdapter(adapter);
//                    hj.setVisibility(View.GONE);
//                }
//
//                @Override
//                public void onFailure(Call<List<students>> call, Throwable throwable) {
//                    hj.setVisibility(View.GONE);
//               ll.setVisibility(VISIBLE);
//                  //  Toast.makeText(pp2activity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
//                    Logger.getLogger(pp2activity.class.getName()).log(Level.SEVERE, "tuff", throwable);
//                }
//            });