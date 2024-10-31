package com.example.progresscheckerforcbc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.progresscheckerforcbc.pp2_material.pp2activity;

public class add_student extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.ftmain), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        EditText tex=findViewById(R.id.adds);
        Button bty=findViewById(R.id.sbt);
        Button byty=findViewById(R.id.sbt2);
    DBHandler dbt=new DBHandler(this);
     String str=tex.getText().toString();

bty.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       dbt.addStudent(str);
        Toast.makeText(add_student.this, "added successfully", Toast.LENGTH_SHORT).show();
    }
});



byty.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent i=new Intent(getApplicationContext(), pp2activity.class);
        startActivity(i);

    }
});












    }
}