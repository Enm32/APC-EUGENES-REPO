package com.example.parents_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.parents_app.models.otpResponse;
import com.example.parents_app.models.signUpresponse;
import com.example.parents_app.models.studentSignup;
import com.example.parents_app.retrofit.getRatings;
import com.example.parents_app.retrofit.retrofit_service;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class sign_upActivity extends AppCompatActivity {

    private String TAG = "NotificationApp";
    String notiftoken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        Button ng=findViewById(R.id.btn_signup);
        EditText et1=findViewById(R.id.et_name);
        EditText et2=findViewById(R.id.et_email);
        EditText et3=findViewById(R.id.sfl);
        EditText et4=findViewById(R.id.pno);
        Spinner  sp=findViewById(R.id.et);
        ProgressBar pb=findViewById(R.id.signup_pb);

        retrofit_service rds = new retrofit_service();
        getRatings ssu=rds.getRetrofit().create(getRatings.class);

        DBHandler dbHandler=new DBHandler(getApplicationContext());




        ng.setOnClickListener(v -> {
            pb.setVisibility(View.VISIBLE);




            FirebaseMessaging.getInstance().getToken()
                    .addOnCompleteListener(task -> {
                        if (!task.isSuccessful()) {
                            //  Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            Toast.makeText(sign_upActivity.this, "fcm error", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        String notiftoken = task.getResult();

                        SharedPreferences sharedpreferences = getSharedPreferences("Important_info", MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString("Grade", sp.getSelectedItem().toString());
                        editor.putString("STUDENT_NAME", et3.getText().toString());
                        editor.putString("Parent_name",et1.getText().toString());
                        editor.putString("Parent_email",et2.getText().toString());
                        editor.putString("Parent_phone",et4.getText().toString());
//                        editor.putString("Parent_phone",et4.getText().toString());
                        editor.putString("NotificationToken",notiftoken);
                        editor.apply();


                        Toast.makeText(sign_upActivity.this,notiftoken , Toast.LENGTH_SHORT).show();
                        // Log.i(TAG, notiftoken.toString());
                        dbHandler.addStudent(et3.getText().toString(),sp.getSelectedItem().toString());

                        studentSignup newStudent=new studentSignup(et3.getText().toString(),et1.getText().toString(),sp.getSelectedItem().toString(),et4.getText().toString(),et2.getText().toString(),notiftoken);
                        ssu.sign_up(newStudent).enqueue(new Callback<signUpresponse>() {
                            @Override
                            public void onResponse(@NonNull Call<signUpresponse> call, @NonNull Response<signUpresponse> response) {
                                pb.setVisibility(View.GONE);
                                Intent mov_next = new Intent(getApplicationContext(), otpLoginActivity.class);
                                mov_next.putExtra("email",et2.getText().toString());
                                mov_next.putExtra("nm",et3.getText().toString());
                                startActivity(mov_next);
                            }

                            @Override
                            public void onFailure(@NonNull Call<signUpresponse> call, @NonNull Throwable throwable) {
                                pb.setVisibility(View.GONE);
                                Toast.makeText(sign_upActivity.this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
                                Logger.getLogger(sign_upActivity.class.getName()).log(Level.SEVERE, "tj", throwable);
                            }
                        });


                    });






        });
    }




}