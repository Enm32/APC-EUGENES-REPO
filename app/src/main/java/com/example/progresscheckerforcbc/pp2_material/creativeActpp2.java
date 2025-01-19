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
import android.widget.Toast;

import com.example.progresscheckerforcbc.R;
import com.example.progresscheckerforcbc.model.add_rating_model;
import com.example.progresscheckerforcbc.model.rating_response;
import com.example.progresscheckerforcbc.retrofit.add_rating_api;
import com.example.progresscheckerforcbc.retrofit.retrofit_service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class creativeActpp2 extends Fragment {

    private String mParam1;

    public creativeActpp2() {

    }


    public static creativeActpp2 newInstance(String param1) {
        creativeActpp2 fragment = new creativeActpp2();
        Bundle args = new Bundle();
        args.putString("ARG_PARAM1", param1);
        fragment.setArguments(args);
        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            mParam1 = bundle.getString("ARG_PARAM1");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rr=  inflater.inflate(R.layout.fragment_capp2, container, false);
        readBundle(getArguments());
       return rr;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            ProgressBar kpb =(ProgressBar) getView().findViewById(R.id.idLoadingPBcapp2);
            Spinner cka1 =getView().findViewById(R.id.myselfpp2Spinner);
            Spinner cka2 =getView().findViewById(R.id.Myhomepp2_Spinner);
            Spinner cka3 =getView().findViewById(R.id.Myschoolpp2_Spinner);
            Spinner cka4 =getView().findViewById(R.id.myFamilypp2spinner);
            retrofit_service rs=new retrofit_service();
            add_rating_api ada=rs.getRetrofit().create(add_rating_api.class);
            add_rating_model mnn=new add_rating_model();

            cka1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kpb.setVisibility(View.VISIBLE);
                        mnn.setStudent_name(mParam1);
                        mnn.setTopic("Myself");
                        mnn.setSubject("Creative Activities pp1");
                        mnn.setTopic_rating(item);
                        makeRating(mnn,ada, kpb);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            cka2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kpb.setVisibility(View.VISIBLE);
                        mnn.setStudent_name(mParam1);
                        mnn.setTopic("My home");
                        mnn.setSubject("Creative Activities pp2");
                        mnn.setTopic_rating(item);
                        makeRating(mnn,ada, kpb);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            cka3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kpb.setVisibility(View.VISIBLE);
                        mnn.setStudent_name(mParam1);
                        mnn.setTopic("My school");
                        mnn.setSubject("Creative Activities pp2");
                        mnn.setTopic_rating(item);
                        makeRating(mnn,ada, kpb);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            cka4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kpb.setVisibility(View.VISIBLE);
                        mnn.setStudent_name(mParam1);
                        mnn.setTopic("My family");
                        mnn.setSubject("Creative Activities pp2");
                        mnn.setTopic_rating(item);
                        makeRating(mnn,ada, kpb);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });



        } catch (Exception e) {
            Toast.makeText(getContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
    }
    private void makeRating(add_rating_model m, add_rating_api n, ProgressBar o){
        n.addRating(m).enqueue(new Callback<rating_response>() {
            @Override
            public void onResponse(Call<rating_response> call, Response<rating_response> response) {
                o.setVisibility(View.GONE);
                Toast.makeText(getContext(),"success",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<rating_response> call, Throwable throwable) {
                o.setVisibility(View.GONE);
                Toast.makeText(getContext(),throwable.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}