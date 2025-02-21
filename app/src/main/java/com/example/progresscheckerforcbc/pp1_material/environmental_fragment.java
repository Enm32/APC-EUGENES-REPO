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


public class environmental_fragment extends Fragment {




    private String mParam1;


    public environmental_fragment() {
        // Required empty public constructor
    }

    public static environmental_fragment newInstance(String param1) {
        environmental_fragment fragment = new environmental_fragment();
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
        View rr=  inflater.inflate(R.layout.fragment_environmental_fragment, container, false);
        readBundle(getArguments());
        return rr;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            ProgressBar kk_pb =(ProgressBar) getView().findViewById(R.id.idLoadingPBcapp1);
            Spinner ea1 =getView().findViewById(R.id.myselfeaSpinner);
            Spinner ea2 =getView().findViewById(R.id.Myhomeea_Spinner);
            Spinner ea3 =getView().findViewById(R.id.Myschoolea_Spinner);
            Spinner ea4 =getView().findViewById(R.id.myFamilyeaspinner);
            Spinner ea5 =getView().findViewById(R.id.Myneighbourhood_Spinner);
            retrofit_service rs=new retrofit_service();
            add_rating_api ada=rs.getRetrofit().create(add_rating_api.class);
            add_rating_model gn =new add_rating_model();
            CryptoManager mnjk=new CryptoManager(getContext());


            String tok=  "Bearer " + mnjk.decrypt_m(mnjk.getKey());

            ea1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kk_pb.setVisibility(View.VISIBLE);
                        gn.setStudent_name(mParam1);
                        gn.setTopic("Myself");
                        gn.setSubject("Environmental Activities PP1");
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ea2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kk_pb.setVisibility(View.VISIBLE);
                        gn.setStudent_name(mParam1);
                        gn.setTopic("My home");
                        gn.setSubject("Environmental Activities PP1");
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ea3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kk_pb.setVisibility(View.VISIBLE);
                        gn.setStudent_name(mParam1);
                        gn.setTopic("My school");
                        gn.setSubject("Environmental Activities PP1");
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ea4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kk_pb.setVisibility(View.VISIBLE);
                        gn.setStudent_name(mParam1);
                        gn.setTopic("My family");
                        gn.setSubject("Environmental Activities PP1");
                        gn.setTopic_rating(item);
                        makeRating(gn,ada, kk_pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            ea5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        kk_pb.setVisibility(View.VISIBLE);
                        gn.setStudent_name(mParam1);
                        gn.setTopic("My family");
                        gn.setSubject("Environmental Activities PP1");
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