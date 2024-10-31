package com.example.progresscheckerforcbc.pp2_material;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.progresscheckerforcbc.R;
import com.example.progresscheckerforcbc.model.add_rating_model;
import com.example.progresscheckerforcbc.model.rating_response;
import com.example.progresscheckerforcbc.retrofit.add_rating_api;
import com.example.progresscheckerforcbc.retrofit.retrofit_service;

import java.util.logging.Level;
import java.util.logging.Logger;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link mathpp2#newInstance} factory method to
// * create an instance of this fragment.
// */
public class mathpp2 extends Fragment {
    private String mParam1;
    private String mParam2;

    public mathpp2() {

    }




    public static mathpp2 newInstance(String param1, String param2) {
        mathpp2 fragment = new mathpp2();
        Bundle args = new Bundle();
        args.putString("p1", param1);
        args.putString("p2", param2);
        fragment.setArguments(args);
        return fragment;
    }

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString("p1");
//            mParam2 = getArguments().getString("p2");
//        }
//
//    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            mParam1 = bundle.getString("p1");
            mParam2 = bundle.getString("p2");
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rr= inflater.inflate(R.layout.fragment_mathpp2, container, false);
        readBundle(getArguments());

        return rr;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            TextView vv=getView().findViewById(R.id.math_multi);
            vv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(),mParam1,Toast.LENGTH_SHORT).show();
                }
            });
        }catch (Exception e){
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            Logger.getLogger(mathpp2.class.getName()).log(Level.SEVERE,"bad stuff",e);
        }






        ProgressBar pb=(ProgressBar) getView().findViewById(R.id.idLoadingPB);
        retrofit_service rs=new retrofit_service();
        add_rating_api ada=rs.getRetrofit().create(add_rating_api.class);
        add_rating_model adm=new add_rating_model();
        adm.setStudent_name(mParam1);
        adm.setTopic("addition");
        adm.setSubject("mathPp2");

        Spinner spp=  getView().findViewById(R.id.additionSpinner);
   spp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
       @Override
       public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
           String item=(String) parent.getSelectedItem();
                    if(item==parent.getItemAtPosition(0)){

                    } else if (item!=parent.getItemAtPosition(0)) {
                        pb.setVisibility(View.VISIBLE);
                        adm.setTopic_rating(item);
                        ada.addRating(adm).enqueue(new Callback<rating_response>() {
                            @Override
                            public void onResponse(Call<rating_response> call, Response<rating_response> response) {
                                pb.setVisibility(View.GONE);
                                Toast.makeText(getContext(),"success",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(Call<rating_response> call, Throwable throwable) {
                                Toast.makeText(getContext(),throwable.getMessage(),Toast.LENGTH_SHORT).show();
                                Logger.getLogger(mathpp2.class.getName()).log(Level.SEVERE,"error occured",throwable);
                            }
                        });
                       // Toast.makeText(getContext(), item +" selected",Toast.LENGTH_SHORT).show();
                    }
       }

       @Override
       public void onNothingSelected(AdapterView<?> parent) {

       }
   });
    }
}