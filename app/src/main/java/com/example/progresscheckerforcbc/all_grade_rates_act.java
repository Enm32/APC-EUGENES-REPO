package com.example.progresscheckerforcbc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.progresscheckerforcbc.Strands.English_upper;
import com.example.progresscheckerforcbc.Strands.*;

public class all_grade_rates_act extends AppCompatActivity {
  String grade,s_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_all_grade_rates);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button b1=findViewById(R.id.Mathematicsbtn);
        Button b2=findViewById(R.id.Englishbtn);
        Button b3=findViewById(R.id.Kiswahilibtn);
        Button b4=findViewById(R.id.Sciencebtn);
        Button b5=findViewById(R.id.SocialStudiesbtn);
        Button b6=findViewById(R.id.CREbtn);
        Button b7=findViewById(R.id.Agriculturebtn);
        Button b8=findViewById(R.id.ArtandCraftbtn);
        Button b9=findViewById(R.id.Environmentalbtn);
        Button b10=findViewById(R.id.homesciencebtn);
        Button b11=findViewById(R.id.hygieneandnutritionbtn);
        Button b12=findViewById(R.id.musicbtn);
        Button b13=findViewById(R.id.pebtn);
        Button b14=findViewById(R.id.pretechnicalstudiesbtn);
        Button b15=findViewById(R.id.visualartsbtn);

        TextView tv=findViewById(R.id.textViewkm);

        Intent intent = getIntent();
         s_name = intent.getStringExtra("s_name");
         grade= intent.getStringExtra("s_grade");
         tv.setText(s_name);

        loadFrag(Mathematics.newInstance(s_name,grade), 0);

        b1.setOnClickListener(v -> {
            loadFrag(Mathematics.newInstance(s_name,grade), 0);
        });
        b2.setOnClickListener(v -> {
            loadFrag(English_upper.newInstance(s_name,grade), 0);
        });
        b3.setOnClickListener(v -> {
            loadFrag(kiswahili_upper.newInstance(s_name,grade), 0);
        });
        b4.setOnClickListener(v -> {
            loadFrag(science_upper.newInstance(s_name,grade), 0);
        });
        b5.setOnClickListener(v -> {
            loadFrag(socialStudies.newInstance(s_name,grade), 0);
        });
        b6.setOnClickListener(v -> {
            loadFrag(Cre_upper.newInstance(s_name,grade), 0);
        });
        b7.setOnClickListener(v -> {
            loadFrag(Agriculture_jss.newInstance(s_name,grade), 0);
        });
        b8.setOnClickListener(v -> {
            loadFrag(ArtandCraft.newInstance(s_name,grade), 0);
        });
        b9.setOnClickListener(v -> {
            loadFrag(Environmental.newInstance(s_name,grade), 0);
        });
        b10.setOnClickListener(v -> {
            loadFrag(Homescience.newInstance(s_name,grade), 0);
        });
        b11.setOnClickListener(v -> {
            loadFrag(HygieneandNutrition.newInstance(s_name,grade), 0);
        });
        b12.setOnClickListener(v -> {
            loadFrag(Music.newInstance(s_name,grade), 0);
        });
        b13.setOnClickListener(v -> {
            loadFrag(Pe.newInstance(s_name,grade), 0);
        });
        b14.setOnClickListener(v -> {
            loadFrag(Pretechnicalstudies.newInstance(s_name,grade), 0);
        });
        b15.setOnClickListener(v -> {
            loadFrag(visual_arts_jss.newInstance(s_name,grade), 0);
        });







    }
    public void loadFrag(Fragment fragment_name, int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag == 0) {

            ft.replace(R.id.FLkl, fragment_name);

            fm.popBackStack();
            // ft.addToBackStack(Root_Frag);

        }
        else {
            ft.replace(R.id.FL, fragment_name);
            // ft.addToBackStack(null);
            fm.popBackStack();
        }

        ft.commit();
    }
}