package com.example.progresscheckerforcbc.pp1_material;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.progresscheckerforcbc.R;
import com.example.progresscheckerforcbc.pp2_material.mathpp2;

public class pp1_rate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pp1_rate);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button ma = findViewById(R.id.mathpp1);
        Button la = findViewById(R.id.lapp1);
        Button ca = findViewById(R.id.capp1);
        CardView ra = findViewById(R.id.rapp1);
        Button ea=findViewById(R.id.eapp1);

         TextView mn=findViewById(R.id.textviewpp1);
         Intent intent = getIntent();
         String strn = intent.getStringExtra("pp1s_name");
         mn.setText(strn);

        loadFrag(math_pp1.newInstance(strn), 0);

ma.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        loadFrag(math_pp1.newInstance(strn), 0);
    }
});

la.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        loadFrag(language_act_pp1.newInstance(strn), 0);
    }
});


ca.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        loadFrag(creative_act_pp1.newInstance(strn), 0);
    }
});


ra.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        loadFrag(religious_act_pp1.newInstance(strn), 0);
    }
});



ea.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        loadFrag(environmental_fragment.newInstance(strn), 0);
    }
});


    }
    public void loadFrag(Fragment fragment_name, int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag == 0) {

            ft.replace(R.id.FLpp1, fragment_name);

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