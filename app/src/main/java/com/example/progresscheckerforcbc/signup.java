package com.example.progresscheckerforcbc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button ng=findViewById(R.id.btn_signup);
        EditText et1=findViewById(R.id.et_name);
        EditText et2=findViewById(R.id.et_email);
        EditText et4=findViewById(R.id.pno);
        ProgressBar pb=findViewById(R.id.signup_pb);
        ng.setOnClickListener(v -> {
          Intent ipo=new Intent(getApplicationContext(), subjectSelection.class);
          ipo.putExtra("teacher_name",et1.getText().toString());
          ipo.putExtra("teacher_email",et2.getText().toString());
          ipo.putExtra("teacher_pno",et4.getText().toString());

          startActivity(ipo);
           });




    }
}