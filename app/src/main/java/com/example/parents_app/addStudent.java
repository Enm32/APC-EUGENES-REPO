package com.example.parents_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.parents_app.models.signUpresponse;
import com.example.parents_app.models.studentSignup;
import com.example.parents_app.retrofit.getRatings;
import com.example.parents_app.retrofit.retrofit_service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class addStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_student);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        EditText eT;Button bt;Spinner sp;ProgressBar jkl_p;
        jkl_p =findViewById(R.id.klpb);
        eT=findViewById(R.id.addstudent_name);bt=findViewById(R.id.btn_addStudent);sp=findViewById(R.id.addStudentSpinner);
        SharedPreferences sharedpreferences = getSharedPreferences("Important_info", MODE_PRIVATE);

        retrofit_service rdk = new retrofit_service();
        getRatings sas=rdk.getRetrofit().create(getRatings.class);
       DBHandler nj=new DBHandler(addStudent.this);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jkl_p.setVisibility(View.VISIBLE);
                nj.addStudent(eT.getText().toString(),sp.getSelectedItem().toString());
                studentSignup newst=new studentSignup(eT.getText().toString(),sharedpreferences.getString("Parent_name"," "),sp.getSelectedItem().toString(),sharedpreferences.getString("Parent_phone"," "),sharedpreferences.getString("Parent_email"," "),sharedpreferences.getString("NotificationToken"," "));
                sas.sign_up(newst).enqueue(new Callback<signUpresponse>() {
                    @Override
                    public void onResponse(Call<signUpresponse> call, Response<signUpresponse> response) {
                        jkl_p.setVisibility(View.GONE);
                        Toast.makeText(addStudent.this, "student Added", Toast.LENGTH_SHORT).show();
                        Intent n=new Intent(getApplicationContext(),students_list.class);
                      startActivity(n);
                    }

                    @Override
                    public void onFailure(Call<signUpresponse> call, Throwable throwable) {
                        jkl_p.setVisibility(View.GONE);
                        Toast.makeText(addStudent.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });









    }
}