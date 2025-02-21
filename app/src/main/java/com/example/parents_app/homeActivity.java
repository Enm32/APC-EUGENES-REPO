package com.example.parents_app;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import javax.crypto.SecretKey;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.messaging.FirebaseMessaging;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.*;

public class homeActivity extends AppCompatActivity {

   // private String messageToEncrypt="hello mnmmmn data";
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
    Toolbar toolbar =  findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
   CryptoManager nm=new CryptoManager(homeActivity.this);
    RecyclerView rv=findViewById(R.id.home_rv);



    SharedPreferences shred_preferences=getSharedPreferences("Important_info",MODE_PRIVATE);
    String cg=shred_preferences.getString("Grade","");
    String hg=shred_preferences.getString("STUDENT_NAME","");
    Toast.makeText(this, hg, Toast.LENGTH_LONG).show();
    ad=new subjects_adapter(homeActivity.this,get_Subjects_array(cg));
    rv.setAdapter(ad);
    rv.setLayoutManager(new LinearLayoutManager(this));

} catch (Exception e) {

    LOGGER.log(Level.SEVERE,"rv error",e);
}


    }
    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        if(menu instanceof MenuBuilder){
            MenuBuilder m = (MenuBuilder) menu;
            m.setOptionalIconsVisible(true);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();


        if (id == R.id.item1) {

            try {


               // Toast.makeText(homeActivity.this,encrypth(messageToEncrypt,mn) , Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
               // throw new RuntimeException(e);
                Toast.makeText(homeActivity.this,e.getMessage(), Toast.LENGTH_SHORT).show();
            }


            return true;
        } else if (id == R.id.item2) {




            return true;
        } else if (id == R.id.item3) {
            Toast.makeText(homeActivity.this, "Shows jdkd icon", Toast.LENGTH_SHORT).show();
            return true;
        }

        return (super.onOptionsItemSelected(item));
    }

    public List<String> get_Subjects_array(String current_grade){


//        switch (current_grade){
//            case "Grade 1":
//                subjects.add("Mathematics");
//                subjects.add("Kiswahili");
//                subjects.add("English");
//                subjects.add("Religous Education");
//                subjects.add("Creative Activities");
//                subjects.add("Environmental activities");
//                subjects.add("Hygiene and Nutrition");
//                return  subjects;
//            case "Grade 2":
//                subjects.add("Mathematics");
//                subjects.add("Kiswahili");
//                subjects.add("English");
//                subjects.add("Religous Education");
//                subjects.add("Creative Activities");
//                subjects.add("Environmental activities");
//                subjects.add("Hygiene and Nutrition");
//                return  subjects;
//            case "Grade 3":
//                subjects.add("Mathematics");
//                subjects.add("Kiswahili");
//                subjects.add("English");
//                subjects.add("Religious Education");
//                subjects.add("Creative Activities");
//                subjects.add("Environmental Activities");
//                subjects.add("Hygiene and Nutrition");
//                return  subjects;
//            case "Grade 4":
//                subjects.add("Mathematics");
//                subjects.add("Kiswahili");
//                subjects.add("English");
//                subjects.add("Religious Education");
//                subjects.add("Creative Activities");
//                subjects.add("Agriculture");
//                subjects.add("Music");
//                subjects.add("PE");
//                subjects.add("Science");
//                subjects.add("Social studies");
//                return  subjects;
//            case "Grade 5":
//                subjects.add("Mathematics");
//                subjects.add("Kiswahili");
//                subjects.add("English");
//                subjects.add("Religious Education");
//                subjects.add("Creative Activities");
//                subjects.add("Agriculture");
//                subjects.add("Music");
//                subjects.add("PE");
//                subjects.add("Science");
//                subjects.add("Social studies");
//                return  subjects;
//            case "Grade 6":
//                subjects.add("Mathematics");
//                subjects.add("Kiswahili");
//                subjects.add("English");
//                subjects.add("Religious Education");
//                subjects.add("Creative Activities");
//                subjects.add("Agriculture");
//                subjects.add("Music");
//                subjects.add("PE");
//                subjects.add("Science");
//                subjects.add("Social studies");
//                return  subjects;
//            case "Grade 7":
//                subjects.add("Mathematics");
//                subjects.add("Kiswahili");
//                subjects.add("English");
//                subjects.add("Religious Education");
//                subjects.add("Home science");
//                subjects.add("Agriculture");
//                subjects.add("Visual arts");
//                subjects.add("PE");
//                subjects.add("Science");
//                subjects.add("Social studies");
//                subjects.add("Pre-Technical Studies");
//                return  subjects;
//            case "Grade 8":
//                subjects.add("Mathematics");
//                subjects.add("Kiswahili");
//                subjects.add("English");
//                subjects.add("Religious Education");
//                subjects.add("Home science");
//                subjects.add("Agriculture");
//                subjects.add("Visual arts");
//                subjects.add("PE");
//                subjects.add("Science");
//                subjects.add("Social studies");
//                subjects.add("Pre-Technical Studies");
//                return  subjects;
//            case "Grade 9":
//                subjects.add("Mathematics");
//                subjects.add("Kiswahili");
//                subjects.add("English");
//                subjects.add("Religious Education");
//                subjects.add("Home science");
//                subjects.add("Agriculture");
//                subjects.add("Visual arts");
//                subjects.add("PE");
//                subjects.add("Science");
//                subjects.add("Social studies");
//                subjects.add("Pre-Technical Studies");
//                return  subjects;
//            case "PP1":
//                subjects.add("Mathematics");
//                subjects.add("Environmental activities");
//                subjects.add("Language Activities");
//                subjects.add("Religious Education");
//                return  subjects;
//            case "PP2":
//                subjects.add("Mathematics");
//                subjects.add("Environmental activities");
//                subjects.add("Language Activities");
//                subjects.add("Religious Education");
//                return  subjects;
//        }
        if (current_grade.equals("Grade 1") || current_grade.equals("Grade 2") || current_grade.equals("Grade 3")) {
            subjects.add("Mathematics");
            subjects.add("Kiswahili");
            subjects.add("English");
            subjects.add("Religious Education");
            subjects.add("Creative Activities");
            subjects.add("Environmental Activities");
            subjects.add("Hygiene and Nutrition");
        } else if (current_grade.equals("Grade 4") || current_grade.equals("Grade 5") || current_grade.equals("Grade 6")) {
            subjects.add("Mathematics");
            subjects.add("Kiswahili");
            subjects.add("English");
            subjects.add("Religious Education");
            subjects.add("Creative Activities");
            subjects.add("Agriculture");
            subjects.add("Music");
            subjects.add("PE");
            subjects.add("Science");
            subjects.add("Social studies");
        } else if (current_grade.equals("Grade 7") || current_grade.equals("Grade 8") || current_grade.equals("Grade 9")) {
            subjects.add("Mathematics");
            subjects.add("Kiswahili");
            subjects.add("English");
            subjects.add("Religious Education");
            subjects.add("Home science");
            subjects.add("Agriculture");
            subjects.add("Visual arts");
            subjects.add("PE");
            subjects.add("Science");
            subjects.add("Social studies");
            subjects.add("Pre-Technical Studies");
        } else if (current_grade.equals("PP1") || current_grade.equals("PP2")) {
            subjects.add("Mathematics");
            subjects.add("Environmental activities");
            subjects.add("Language Activities");
            subjects.add("Religious Education");
        }

        return subjects;

 }



}