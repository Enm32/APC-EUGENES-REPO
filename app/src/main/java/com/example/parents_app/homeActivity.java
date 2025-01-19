package com.example.parents_app;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.*;

public class homeActivity extends AppCompatActivity {

    private String messageToEncrypt="hello mnmmmn data";
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
    TextView nh=findViewById(R.id.ktitle);


    SharedPreferences shred_preferences=getSharedPreferences("Important_info",MODE_PRIVATE);
    String cg=shred_preferences.getString("Grade","");
    ad=new subjects_adapter(homeActivity.this,get_Subjects_array(cg));
    rv.setAdapter(ad);
    rv.setLayoutManager(new LinearLayoutManager(this));
//SecretKey mk=create_Key();
   // byte[] mn=nm.encrypth(messageToEncrypt,nm.getKey());
    //Toast.makeText(homeActivity.this,decrypt_m(mk,mn), Toast.LENGTH_LONG).show();

 // nh.setText(decrypt_m(mk,mn));
   // nh.setText(nm.decrypt_m(nm.getKey()));
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

      if(current_grade.equals("Grade1")){
          subjects.add("mathematics");
          subjects.add("social activities");
          subjects.add("hygiene science");
      }else{
          subjects.add("science");
          subjects.add("english");
          subjects.add("cre");
      }
     return  subjects;

 }

//    private SecretKey create_Key() throws Exception{
//        KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
//        keyGenerator.init(
//                new KeyGenParameterSpec.Builder("MySecureKey",
//                        KeyProperties.PURPOSE_ENCRYPT | KeyProperties.PURPOSE_DECRYPT)
//                        .setBlockModes(KeyProperties.BLOCK_MODE_GCM)
//                        .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
//                        .setUserAuthenticationRequired(false)
//                        .build()
//        );
//        SecretKey secretKey = keyGenerator.generateKey();
//        return secretKey;
//    }


}