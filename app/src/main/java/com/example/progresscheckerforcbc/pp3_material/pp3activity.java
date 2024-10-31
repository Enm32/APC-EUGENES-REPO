package com.example.progresscheckerforcbc.pp3_material;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.progresscheckerforcbc.R;

import java.util.logging.Level;
import java.util.logging.Logger;

public class pp3activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pp3activity);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

try {
    Toolbar yb=findViewById(R.id.toolbar);
    setSupportActionBar(yb);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
}
 catch(Exception e){
     Logger.getLogger(pp3activity.class.getName()).log(Level.SEVERE,"io",e);
 }

    }
}