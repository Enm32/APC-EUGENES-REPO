package com.example.parents_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.*;

public class homeActivity extends AppCompatActivity {
    List<String> subjects=new ArrayList<>();
    subjects_adapter ad;

    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
try {
    RecyclerView rv=findViewById(R.id.home_rv);
    subjects.add("Math");
    subjects.add("English");
    subjects.add("social activities");
    ad=new subjects_adapter(homeActivity.this,subjects);
    rv.setAdapter(ad);

    rv.setLayoutManager(new LinearLayoutManager(this));
} catch (Exception e) {

    LOGGER.log(Level.SEVERE,"rv error",e);
}


    }
}