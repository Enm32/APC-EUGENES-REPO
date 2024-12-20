package com.example.progresscheckerforcbc.pp2_material;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.progresscheckerforcbc.R;
import com.example.progresscheckerforcbc.pp2_material.englishpp2frag;
import com.example.progresscheckerforcbc.pp2_material.mathpp2;
import com.example.progresscheckerforcbc.pp2_material.sciencepp2frag;

public class rates extends AppCompatActivity {

   // private static final int PERMISSION_REQUEST_CODE = 200;


    String Root_Frag = "root_fagment";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_rates);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button btnMath, btneng, btnscience;

        btnMath = findViewById(R.id.mathpp2);
        btneng = findViewById(R.id.englishpp2);
        btnscience = findViewById(R.id.sciencepp2);
        TextView sname=findViewById(R.id.textView2);
        Intent intent = getIntent();
        String strn = intent.getStringExtra("s_name");
        sname.setText(strn);

        // default frag
       loadFrag(mathpp2.newInstance(strn,"mne"), 0);

        btnMath.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                loadFrag(mathpp2.newInstance(strn,"mne"), 0);
            }
        });

        btneng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                loadFrag(new englishpp2frag(), 1);
            }
        });

        btnscience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                loadFrag(new sciencepp2frag(), 1);
            }
        });
    }

    // flag 0 for add, 1 for replace
    public void loadFrag(Fragment fragment_name, int flag)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        if (flag == 0) {

            ft.replace(R.id.FL, fragment_name);

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

/*
       Button generatePDF_btn;

        generatePDF_btn=findViewById(R.id.pdf_button);
        String subject="math.png";
        Spinner sp=findViewById(R.id.mathtopicsspinner);
        Spinner spp=findViewById(R.id.mathratingspinner);

        TextView sname=findViewById(R.id.textView2);
        Intent intent = getIntent();
        String strn = intent.getStringExtra("s_name");
        sname.setText(strn);
        ArrayList<String> math_topics=new ArrayList<>();

        math_topics.add("fractions");
        math_topics.add("decimals");
        math_topics.add("multiplication and addition");
        ArrayAdapter<String> ad=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,math_topics);
        sp.setAdapter(ad);
        ArrayList<String> math_ratings=new ArrayList<>();

        math_ratings.add("bad");
        math_ratings.add("average");
        math_ratings.add("good");
        ArrayAdapter<String> add=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,math_ratings);
        spp.setAdapter(add);



        DBHandler dg=new DBHandler(this);

       // DBHandler gh=new DBHandler(this);
        //String nm="Eugene Ndungu";



       sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position1, long id) {
                spp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        dg.addRating(strn,subject,math_topics.get(position1).toString(),math_ratings.get(position).toString());
                       // Toast.makeText(rates.this,math_topics.get(position1)+ " set to " +math_ratings.get(position),Toast.LENGTH_SHORT).show();
                        Toast.makeText(rates.this, "Rating has been added.", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });



               // Toast.makeText(rates.this,math_ratings.get(position)+ " selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



       if (checkPermission()) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            requestPermission();
        }




            generatePDF_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ArrayList<String> ratings = new ArrayList<>();
                    try{
                    ratings = dg.readRating(strn);
                  //  if (ratings == null){
                      //  Toast.makeText(rates.this,"no record", Toast.LENGTH_LONG).show();
                  //  }else{
                    generate_pdf(ratings, strn);}
                    catch(Exception e){
                        Toast.makeText(rates.this, "not possible without first entering a rating", Toast.LENGTH_LONG).show();
                    }

                }


            });
*/

    }
  /* private void generate_pdf(ArrayList<String> jk,String s_tnn){
        int pageHeight = 1120;
        int pagewidth = 792;
       ArrayList<String> details=new ArrayList<>();
       details=jk;
        // creating an object variable
        // for our PDF document.

        PdfDocument pdfDocument = new PdfDocument();

        // two variables for paint "paint" is used
        // for drawing shapes and we will use "title"
        // for adding text in our PDF file.
        Paint paint = new Paint();
        Paint title = new Paint();

        // we are adding page info to our PDF file
        // in which we will be passing our pageWidth,
        // pageHeight and number of pages and after that
        // we are calling it to create our PDF.
        PdfDocument.PageInfo mypageInfo = new PdfDocument.PageInfo.Builder(pagewidth, pageHeight, 1).create();

        // below line is used for setting
        // start page for our PDF file.
        PdfDocument.Page myPage = pdfDocument.startPage(mypageInfo);

        // creating a variable for canvas
        // from our page of PDF.
        Canvas canvas = myPage.getCanvas();

        // below line is used to draw our image on our PDF file.
        // the first parameter of our drawbitmap method is
        // our bitmap
        // second parameter is position from left
        // third parameter is position from top and last
        // one is our variable for paint.
      //  canvas.drawBitmap(scaledbmp, 56, 40, paint);

        // below line is used for adding typeface for
        // our text which we will be adding in our PDF file.
        title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));

        // below line is used for setting text size
        // which we will be displaying in our PDF file.
        title.setTextSize(15);

        // below line is sued for setting color
        // of our text inside our PDF file.
        title.setColor(ContextCompat.getColor(this, R.color.black));

        // below line is used to draw text in our PDF file.
        // the first parameter is our text, second parameter
        // is position from start, third parameter is position from top
        // and then we are passing our variable of paint which is title.
        canvas.drawText("Students report card", 209, 100, title);
        canvas.drawText("see your child's report", 209, 80, title);

        // similarly we are creating another text and in this
        // we are aligning this text to center of our PDF file.
        title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        title.setColor(ContextCompat.getColor(this, R.color.black));
        title.setTextSize(15);

        // below line is used for setting
        // our text to center of PDF.
        title.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(details.get(0)+" "+details.get(1), 396, 560, title);

        // after adding all attributes to our
        // PDF file we will be finishing our page.
        pdfDocument.finishPage(myPage);

        // below line is used to set the name of
        // our PDF file and its path.
        File store_dir=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS);
        File file = new File(store_dir,  s_tnn+"report.pdf");

        try {
            // after creating a file name we will
            // write our PDF file to that location.
            pdfDocument.writeTo(new FileOutputStream(file));

            // below line is to print toast message
            // on completion of PDF generation.
            Toast.makeText(rates.this, "PDF file generated successfully.", Toast.LENGTH_SHORT).show();
        }  catch (SQLException g) {
            // below line is used
            // to handle error
            //Log.d("my_log","error occurred"+ e.toString());
            Toast.makeText(rates.this, g.getMessage() , Toast.LENGTH_SHORT).show();
            throw new RuntimeException(g);

            //e.printStackTrace();
        } catch (IOException e){
           // Log.d("my_log","error occurred"+ e.toString());
            Toast.makeText(rates.this, e.getMessage().toString() , Toast.LENGTH_SHORT).show();
            throw new RuntimeException(e);
        }
        // after storing our pdf to that
        // location we are closing our PDF file.
        pdfDocument.close();

    }

    private boolean checkPermission() {
        // checking of permissions.
        int permission1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
    }
   private void requestPermission() {
        // requesting permissions if not provided.
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {

                // after requesting permissions we are showing
                // users a toast message of permission granted.
                boolean writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if (writeStorage && readStorage) {
                    Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission Denied.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    } */


