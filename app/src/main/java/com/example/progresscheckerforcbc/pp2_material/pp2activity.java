package com.example.progresscheckerforcbc.pp2_material;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progresscheckerforcbc.R;
import com.example.progresscheckerforcbc.model.students;
import com.example.progresscheckerforcbc.retrofit.getStudents_api;
import com.example.progresscheckerforcbc.retrofit.retrofit_service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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


       RecyclerView cr = findViewById(R.id.rv_students);
        cr.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

     //  DBHandler ghk = new DBHandler(this);
       //ArrayList<students_name> hju = ghk.read_student();
        retrofit_service rfs=new retrofit_service();
        getStudents_api gsa=rfs.getRetrofit().create(getStudents_api.class);
        gsa.getStudents().enqueue(new Callback<List<students>>() {
            @Override
            public void onResponse(Call<List<students>> call, Response<List<students>> response) {
                s_names=response.body();
                rv_adapter adapter = new rv_adapter(pp2activity.this);
                adapter.setSn(s_names);
                cr.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<students>> call, Throwable throwable) {
                 Toast.makeText(pp2activity.this,throwable.getMessage(),Toast.LENGTH_SHORT).show();
                Logger.getLogger(pp2activity.class.getName()).log(Level.SEVERE,"tuff",throwable);
            }
        });
//       String nms="martin munene";
//        s_names.add(new students_name("Eugene Ndungu"));
//        s_names.add(new students_name("Edwin Mureithi"));
//        s_names.add(new students_name("Kevin Kamau"));
//        s_names.add(new students_name("Ken kevin"));
//        s_names.add(new students_name("Mathew max"));
//        s_names.add(new students_name("Edna Maggy"));
//        s_names.add(new students_name(nms));
//        s_names.add(new students_name("Ejkklll kll"));
//        s_names.add(new students_name("wycliffe alfred"));
//        s_names.add(new students_name("wyd"));
//        s_names.add(new students_name("martin"));





     /*  Button jkl = findViewById(R.id.add_new_s);
       jkl.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent ik = new Intent(getApplicationContext(), add_student.class);
               startActivity(ik);
           }
       }); */


/*
        TextView a=findViewById(R.id.wtr);
        TextView b=findViewById(R.id.martin);
        TextView c=findViewById(R.id.emma);
        TextView d=findViewById(R.id.kevin);
        String str=a.getText().toString();

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),rates.class);
                i.putExtra("s_name",str);
                startActivity(i);
            }
        });*/




    }

}