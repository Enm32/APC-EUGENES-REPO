package com.example.progresscheckerforcbc;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.progresscheckerforcbc.grade1_material.grade1activity;
import com.example.progresscheckerforcbc.grade2_material.g2activity;
import com.example.progresscheckerforcbc.grade3_material.g3;
import com.example.progresscheckerforcbc.grade4_material.g4;
import com.example.progresscheckerforcbc.grade5_material.g5;
import com.example.progresscheckerforcbc.grade6_material.g6;
import com.example.progresscheckerforcbc.grade7_material.g7;
import com.example.progresscheckerforcbc.grade8_material.g8;
import com.example.progresscheckerforcbc.grade9_material.g9;
import com.example.progresscheckerforcbc.pp1_material.pp1activity;
import com.example.progresscheckerforcbc.pp2_material.englishpp2frag;
import com.example.progresscheckerforcbc.pp2_material.pp2activity;
import com.example.progresscheckerforcbc.pp3_material.pp3activity;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    @Override
    public void onClick(View v) {
        int id=v.getId();
           if( id== R.id.grade1card) {
               Intent i = new Intent(getApplicationContext(), grade1activity.class);
               startActivity(i);
           } else if (id== R.id.grade2card) {
               Intent io = new Intent(getApplicationContext(), g2activity.class);
               startActivity(io);
           } else if (id==R.id.grade3card) {
               Intent iu = new Intent(getApplicationContext(), g3.class);
               startActivity(iu);
           } else if (id==  R.id.grade4card) {
               Intent ih = new Intent(getApplicationContext(), g4.class);
               startActivity(ih);
           } else if (id==R.id.grade5card) {
                   Intent iy = new Intent(getApplicationContext(), g5.class);
                   startActivity(iy);
           } else if (id==R.id.grade6card) {
                   Intent ip = new Intent(getApplicationContext(), g6.class);
                   startActivity(ip);
           } else if (id== R.id.grade7card) {
               Intent ii = new Intent(getApplicationContext(), g7.class);
               startActivity(ii);
           } else if (id==R.id.grade8card) {
                   Intent iyj = new Intent(getApplicationContext(), g8.class);
                   startActivity(iyj);
           } else if (id==R.id.grade9card) {
                   Intent it = new Intent(getApplicationContext(), g9.class);
                   startActivity(it);
           }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

           // setTheme(R.style.Theme_ProgressCheckerForcbc);
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);

            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
            try {
                Toolbar tb = findViewById(R.id.mainAct_toolbar);
                setSupportActionBar(tb);

            } catch (Exception e) {
                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, "enm", e);
            }


            CardView cv = findViewById(R.id.pp1card);
            CardView cv1 = findViewById(R.id.pp2card);
            CardView cv2 = findViewById(R.id.pp3card);
            CardView vv = findViewById(R.id.grade1card);
            CardView vv3 = findViewById(R.id.grade2card);
            CardView g3 = findViewById(R.id.grade3card);
            CardView g4 = findViewById(R.id.grade4card);
            CardView g5 = findViewById(R.id.grade5card);
            CardView g6 = findViewById(R.id.grade6card);
            CardView g7 = findViewById(R.id.grade7card);
            CardView g8 = findViewById(R.id.grade8card);
            CardView g9 = findViewById(R.id.grade9card);


            cv.setOnClickListener(v -> {
                Intent i = new Intent(getApplicationContext(), pp1activity.class);

                startActivity(i);
            });
            cv1.setOnClickListener(v -> {
                Intent i = new Intent(getApplicationContext(), pp2activity.class);

                startActivity(i);
            });

            cv2.setOnClickListener(v -> {
                Intent i = new Intent(getApplicationContext(), otLogin.class);

                startActivity(i);
            });
            vv.setOnClickListener(this);
            vv3.setOnClickListener(this);
            g3.setOnClickListener(this);
            g4.setOnClickListener(this);
            g5.setOnClickListener(this);
            g6.setOnClickListener(this);
            g7.setOnClickListener(this);
            g8.setOnClickListener(this);
            g9.setOnClickListener(this);



    }
}