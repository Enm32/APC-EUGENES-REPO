package com.example.progresscheckerforcbc;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.progresscheckerforcbc.model.signUpresponse;
import com.example.progresscheckerforcbc.model.teacher_sign_up;
import com.example.progresscheckerforcbc.retrofit.new_teacher;
import com.example.progresscheckerforcbc.retrofit.retrofit_service;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class subjectSelection extends AppCompatActivity {
  Spinner s1,s2,s3,s4,s5,s6,s7,s8,s9,s10,s11,s12,s13,s14,s15,s16,s17;
  Button bnl;
  List<String> subjects=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_subject_selection);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        s1=findViewById(R.id.tv1spinner);
        s2=findViewById(R.id.tv2spinner);
        s3=findViewById(R.id.tv3spinner);
        s4=findViewById(R.id.tv4spinner);
        s5=findViewById(R.id.tv5spinner);
        s6=findViewById(R.id.tv6spinner);
        s7=findViewById(R.id.tv7spinner);
        s8=findViewById(R.id.tv8spinner);
        s9=findViewById(R.id.tv9spinner);
        s10=findViewById(R.id.tv10spinner);
        s11=findViewById(R.id.tv11spinner);
        s12=findViewById(R.id.tv12spinner);
        s13=findViewById(R.id.tv13spinner);
        s14=findViewById(R.id.tv14spinner);
        s15=findViewById(R.id.tv15spinner);
        s16=findViewById(R.id.tv16spinner);
        s17=findViewById(R.id.tv17spinner);
       bnl=findViewById(R.id.completeSignup);
        ProgressBar progressBar=findViewById(R.id.sPb);
        Intent k_L = getIntent();
        String st1 = k_L.getStringExtra("teacher_name");
        String st2 = k_L.getStringExtra("teacher_email");
        String st3 = k_L.getStringExtra("teacher_pno");







        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                     subjects.add("CreativeActivities_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("LanguageActivities_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                     subjects.add("EnvironmentalActivities_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("ReligiousActivities_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("MathematicsActivities_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("Agriculture_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s7.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("ArtsandCraft_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s8.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("HomeScience_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s9.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("Hygiene_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s10.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("Music_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s11.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("PE_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s12.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("PretechnicalStudies_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s13.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("science_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s14.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("SocialStudies_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s15.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("VisualArts_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s16.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("English_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        s17.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item=(String) parent.getSelectedItem();
                if(item!=parent.getItemAtPosition(0)){
                    subjects.add("Kiswahili_"+item);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        teacher_sign_up new_Teacher=new teacher_sign_up(st1,subjects,st3);



        retrofit_service rs_signup = new retrofit_service();
        new_teacher signUpApi = rs_signup.getRetrofit().create(new_teacher.class);

bnl.setOnClickListener(v -> {
    progressBar.setVisibility(View.VISIBLE);
    signUpApi.teacher_signup(new_Teacher).enqueue(new Callback<signUpresponse>() {
        @Override
        public void onResponse(Call<signUpresponse> call, Response<signUpresponse> response) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(subjectSelection.this, "sign complete", Toast.LENGTH_LONG).show();

             Intent knm=new Intent(getApplicationContext(),otLogin.class);
             knm.putExtra("T_name",st1);
             knm.putExtra("T_email",st2);
             startActivity(knm);
        }

        @Override
        public void onFailure(Call<signUpresponse> call, Throwable throwable) {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(subjectSelection.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
        }
    });
});




    }
}




