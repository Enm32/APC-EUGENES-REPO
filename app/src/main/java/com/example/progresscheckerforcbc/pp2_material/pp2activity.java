package com.example.progresscheckerforcbc.pp2_material;

import static android.view.View.VISIBLE;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progresscheckerforcbc.NetworkUtil;
import com.example.progresscheckerforcbc.R;
import com.example.progresscheckerforcbc.model.students;
import com.example.progresscheckerforcbc.retrofit.getStudents_api;
import com.example.progresscheckerforcbc.retrofit.retrofit_service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pp2activity extends AppCompatActivity {
    List<students> s_names=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pp2activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        Toolbar yb=findViewById(R.id.pp2_toolbar);
        setSupportActionBar(yb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout ll=findViewById(R.id.net_state);
        ProgressBar hj=findViewById(R.id.stpb);


            RecyclerView cr = findViewById(R.id.rv_students);
            cr.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//            hj.setVisibility(VISIBLE);
//
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

       String nms="martin munene";

        s_names.add(new students("Edwin Mureithi"));
        s_names.add(new students("Kevin Kamau"));
        s_names.add(new students("Ken kevin"));
        s_names.add(new students("Mathew max"));
        s_names.add(new students("Edna Maggy"));
        s_names.add(new students(nms));
        s_names.add(new students("Ejkklll kll"));
        s_names.add(new students("wycliffe alfred"));
        s_names.add(new students("wyd"));
        s_names.add(new students("martin"));
        rv_adapter adapter = new rv_adapter(pp2activity.this);
                adapter.setSn(s_names);
                cr.setAdapter(adapter);










    }


        public void check_connection(LinearLayout kkl){
        String State= NetworkUtil.getConnectivityStatusString(pp2activity.this);
        if(State=="no internet"){
            kkl.setVisibility(VISIBLE);
        }
        }

}