package com.example.progresscheckerforcbc.pp1_material;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progresscheckerforcbc.R;
import com.example.progresscheckerforcbc.model.students;
import com.example.progresscheckerforcbc.pp2_material.pp2activity;
import com.example.progresscheckerforcbc.pp2_material.rv_adapter;

import java.util.ArrayList;
import java.util.List;


public class pp1activity extends AppCompatActivity {
    List<students> s_names=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pp1activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pp1_main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Toolbar yob=findViewById(R.id.pp3_toolbar);
        setSupportActionBar(yob);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView cr = findViewById(R.id.rv_pp1students);
        cr.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
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
        pp1_rvAdapter adapter = new pp1_rvAdapter(pp1activity.this);
        adapter.setSn(s_names);
        cr.setAdapter(adapter);



    }
}