package com.example.progresscheckerforcbc.pp1_material;

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

import com.example.progresscheckerforcbc.CryptoManager;
import com.example.progresscheckerforcbc.R;
import com.example.progresscheckerforcbc.model.add_rating_model;
import com.example.progresscheckerforcbc.model.rating_response;
import com.example.progresscheckerforcbc.retrofit.add_rating_api;
import com.example.progresscheckerforcbc.retrofit.retrofit_service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class religious_act_pp1 extends Fragment {
    private String mParam1;

    public religious_act_pp1() {
        // Required empty public constructor
    }


    public static religious_act_pp1 newInstance(String param1) {
        religious_act_pp1 fragment = new religious_act_pp1();
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
        View rr=  inflater.inflate(R.layout.fragment_religious_act_pp1, container, false);
        readBundle(getArguments());
        return rr;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            ProgressBar kk_pb =(ProgressBar) getView().findViewById(R.id.idLoadingPBcapp1);
            Spinner ra1 =getView().findViewById(R.id.CreationPp1_Spinner);
            Spinner ra2 =getView().findViewById(R.id.LOJpp1Spinner);
            Spinner ra3 =getView().findViewById(R.id.TheBiblePP1spinner);
            Spinner ra4 =getView().findViewById(R.id.CValuesPP1_Spinner);
            Spinner ra5 =getView().findViewById(R.id.ChurchPP1_Spinner);
            CryptoManager mnjk=new CryptoManager(getContext());


            String tok=  "Bearer " + mnjk.decrypt_m(mnjk.getKey());
            retrofit_service rs=new retrofit_service();
            add_rating_api ada=rs.getRetrofit().create(add_rating_api.class);
            add_rating_model gn =new add_rating_model();

            ra1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kk_pb.setVisibility(View.VISIBLE);
                        gn.setStudent_name(mParam1);
                        gn.setTopic("Creation");
                        gn.setSubject("Religious Activities pp1");
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ra2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kk_pb.setVisibility(View.VISIBLE);
                        gn.setStudent_name(mParam1);
                        gn.setTopic("Life of Jesus");
                        gn.setSubject("Religious Activities pp1");
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ra3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kk_pb.setVisibility(View.VISIBLE);
                        gn.setStudent_name(mParam1);
                        gn.setTopic("The bible");
                        gn.setSubject("Religious Activities pp1");
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ra4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kk_pb.setVisibility(View.VISIBLE);
                        gn.setStudent_name(mParam1);
                        gn.setTopic("Christian values");
                        gn.setSubject("Religious Activities pp1");
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ra5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kk_pb.setVisibility(View.VISIBLE);
                        gn.setStudent_name(mParam1);
                        gn.setTopic("The church");
                        gn.setSubject("Religious Activities pp1");
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb,tok);
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
    private void makeRating(add_rating_model m, add_rating_api n, ProgressBar o,String auth){
        n.addRating(auth,m).enqueue(new Callback<rating_response>() {
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