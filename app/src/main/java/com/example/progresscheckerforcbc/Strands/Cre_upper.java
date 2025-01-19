package com.example.progresscheckerforcbc.Strands;

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


public class Cre_upper extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String s_name;
    private String grade;

    public Cre_upper() {
        // Required empty public constructor
    }


    public static Cre_upper newInstance(String param1, String param2) {
        Cre_upper fragment = new Cre_upper();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            s_name = getArguments().getString(ARG_PARAM1);
            grade = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cre_upper, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            ProgressBar kk_pb =(ProgressBar) getView().findViewById(R.id.idLoadingPB_CRE);
            Spinner ra1 =getView().findViewById(R.id.Creationn);
            Spinner ra2 =getView().findViewById(R.id.LOJnSpinner);
            Spinner ra3 =getView().findViewById(R.id.TheBiblenspinner);
            Spinner ra4 =getView().findViewById(R.id.CValuesnSpinner);
            Spinner ra5 =getView().findViewById(R.id.ChurchnSpinner);
            retrofit_service rs=new retrofit_service();
            add_rating_api ada=rs.getRetrofit().create(add_rating_api.class);
            add_rating_model gn =new add_rating_model();

            ra1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kk_pb.setVisibility(View.VISIBLE);
                        gn.setStudent_name(s_name);
                        gn.setTopic("Creation");
                        gn.setSubject("Religious Activities "+ grade);
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb);
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
                        gn.setStudent_name(s_name);
                        gn.setTopic("Life of Jesus");
                        gn.setSubject("Religious Activities "+ grade);
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb);
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
                        gn.setStudent_name(s_name);
                        gn.setTopic("The bible");
                        gn.setSubject("Religious Activities "+ grade);
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb);
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
                        gn.setStudent_name(s_name);
                        gn.setTopic("Christian values");
                        gn.setSubject("Religious Activities "+ grade);
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb);
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
                        gn.setStudent_name(s_name);
                        gn.setTopic("The church");
                        gn.setSubject("Religious Activities "+ grade);
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb);
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