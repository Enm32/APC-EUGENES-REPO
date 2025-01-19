package com.example.progresscheckerforcbc.grade1_material;

import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
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
import com.example.progresscheckerforcbc.pp2_material.pp2activity;
import com.example.progresscheckerforcbc.pp2_material.rv_adapter;

import java.util.ArrayList;
import java.util.List;

public class grade1activity extends AppCompatActivity {

    List<students> sNames =new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_grade1activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Toolbar yb=findViewById(R.id.grade1_toolbar);
        setSupportActionBar(yb);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        LinearLayout ll=findViewById(R.id.net_stateg1);
        ProgressBar hj=findViewById(R.id.g1pb);

//            hj.setVisibility(VISIBLE);
//
//            retrofit_service rfs = new retrofit_service();
//            getStudents_api gsa = rfs.getRetrofit().create(getStudents_api.class);
//            gsa.getStudents().enqueue(new Callback<List<students>>() {
//                @Override
//                public void onResponse(Call<List<students>> call, Response<List<students>> response) {
//                    sNames = response.body();
//                    rv_adapter adapter = new rv_adapter(pp2activity.this);
//                    adapter.setSn(sNames);
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
        RecyclerView cr = findViewById(R.id.g1_rv_students);
        cr.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        String nms="martin munene";

        sNames.add(new students("Edwin Mureithi"));
        sNames.add(new students("Kevin Kamau"));
        sNames.add(new students("Ken kevin"));
        sNames.add(new students("Mathew max"));
        sNames.add(new students("Edna Maggy"));
        sNames.add(new students(nms));
        sNames.add(new students("Ejkklll kll"));
        sNames.add(new students("wycliffe alfred"));
        sNames.add(new students("wyd"));
        sNames.add(new students("martin"));
        rv_adapter adapter = new rv_adapter(grade1activity.this,"Grade 1");
        adapter.setSn(sNames);
        cr.setAdapter(adapter);






    }
//    public void check_connection(LinearLayout kkl){
//        String State= NetworkUtil.getConnectivityStatusString(grade1activity.this);
//        if(State=="no internet"){
//            kkl.setVisibility(VISIBLE);
//        }
//    }
}