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

import com.example.progresscheckerforcbc.CryptoManager;
import com.example.progresscheckerforcbc.R;
import com.example.progresscheckerforcbc.model.add_rating_model;
import com.example.progresscheckerforcbc.model.rating_response;
import com.example.progresscheckerforcbc.retrofit.add_rating_api;
import com.example.progresscheckerforcbc.retrofit.retrofit_service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Mathematics extends Fragment {




    private String mParam1;
    private String mParam2;

    public Mathematics() {
        // Required empty public constructor
    }


    public static Mathematics newInstance(String sName, String grade) {
        Mathematics fragment = new Mathematics();
        Bundle args = new Bundle();
        args.putString("studentName", sName);
        args.putString("grade", sName);
        fragment.setArguments(args);
        return fragment;
    }

    private void readBundle(Bundle bundle) {
        if (bundle != null) {
            mParam1 = bundle.getString("studentName");
            mParam2= bundle.getString("grade");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View r= inflater.inflate(R.layout.fragment_mathematics, container, false);
        readBundle(getArguments());
        return r;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            ProgressBar pb=(ProgressBar) getView().findViewById(R.id.idLoadingPB19);
            Spinner k1=getView().findViewById(R.id.DHSpinner);
            Spinner k2=getView().findViewById(R.id.Numbers_sp);
            Spinner k3=getView().findViewById(R.id.Measurement_sp);
            Spinner k4=getView().findViewById(R.id.geometry_Spinner);
            Spinner k5=getView().findViewById(R.id.Algebra_Spinner);



            CryptoManager mnjk=new CryptoManager(getContext());
            String tok=  "Bearer " + mnjk.decrypt_m(mnjk.getKey());

            retrofit_service rs=new retrofit_service();
            add_rating_api ada=rs.getRetrofit().create(add_rating_api.class);
            add_rating_model kadm=new add_rating_model();

           k1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(mParam1);
                        kadm.setTopic("Data Handling");
                        kadm.setSubject("Mathematics "+ mParam2);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            k2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(mParam1);
                        kadm.setTopic("Numbers");
                        kadm.setSubject("Mathematics "+ mParam2);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            k3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(mParam1);
                        kadm.setTopic("Measurement");
                        kadm.setSubject("Mathematics "+ mParam2);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            k4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(mParam1);
                        kadm.setTopic("Geometry");
                        kadm.setSubject("Mathematics "+ mParam2);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            k5.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(mParam1);
                        kadm.setTopic("Algebra");
                        kadm.setSubject("Mathematics "+ mParam2);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb,tok);
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