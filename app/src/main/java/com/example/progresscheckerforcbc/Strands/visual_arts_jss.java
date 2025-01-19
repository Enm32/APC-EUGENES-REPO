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


public class visual_arts_jss extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String s_name;
    private String grade;

    public visual_arts_jss() {
        // Required empty public constructor
    }



    public static visual_arts_jss newInstance(String name, String s_grade) {
        visual_arts_jss fragment = new visual_arts_jss();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, name);
        args.putString(ARG_PARAM2, s_grade);
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

        return inflater.inflate(R.layout.fragment_visual_arts_jss, container, false);
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            ProgressBar pb=(ProgressBar) getView().findViewById(R.id.idLoadingPBva);
            Spinner nmna=getView().findViewById(R.id.foundations_Spinner);
            Spinner j =getView().findViewById(R.id.cpcasspinner);
            Spinner k =getView().findViewById(R.id.appreciationSpinner);



            retrofit_service rs=new retrofit_service();
            add_rating_api ada=rs.getRetrofit().create(add_rating_api.class);
            add_rating_model kadm=new add_rating_model();



            nmna.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(s_name);
                        kadm.setTopic("Foundations of Creative Arts and Sports");
                        kadm.setSubject("Visual arts "+ grade);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });


            j.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(s_name);
                        kadm.setTopic("CCreating and Performing in Creative arts");
                        kadm.setSubject("Visual arts "+ grade);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            k.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(s_name);
                        kadm.setTopic("Appreciation in Creative Arts and Sports");
                        kadm.setSubject("Visual arts "+ grade);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb);
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