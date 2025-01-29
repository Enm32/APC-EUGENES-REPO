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


public class English_upper extends Fragment {

    private String mParam1;
    private String mParam2;

    public English_upper() {

    }


    public static English_upper newInstance(String sName, String grade) {
        English_upper fragment = new English_upper();
        Bundle args = new Bundle();
        args.putString("studentName", sName);
        args.putString("grade", grade);
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
        View rj= inflater.inflate(R.layout.fragment_english, container, false);
        readBundle(getArguments());
        return rj;
    }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            ProgressBar pb=(ProgressBar) getView().findViewById(R.id.PB_eng);
            Spinner j =getView().findViewById(R.id.Reading_spnr);
            Spinner k =getView().findViewById(R.id.Writing_eng);
            Spinner jnm =getView().findViewById(R.id.Listening_speakingSpinner);
            Spinner jkm =getView().findViewById(R.id.actHomeSpinner);
            Spinner mnb =getView().findViewById(R.id.actSchoolSpinner);
            Spinner mlb =getView().findViewById(R.id.OccupationsSpinner);

            CryptoManager mnjk=new CryptoManager(getContext());
            String tok=  "Bearer " + mnjk.decrypt_m(mnjk.getKey());

            retrofit_service rs=new retrofit_service();
            add_rating_api ada=rs.getRetrofit().create(add_rating_api.class);
            add_rating_model kadm=new add_rating_model();

            j.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(mParam1);
                        kadm.setTopic("Reading");
                        kadm.setSubject("English "+ mParam2);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb,tok);
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
                        kadm.setStudent_name(mParam1);
                        kadm.setTopic("Writing");
                        kadm.setSubject("English "+ mParam2);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            jnm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(mParam1);
                        kadm.setTopic("Listening and Speaking");
                        kadm.setSubject("English "+ mParam2);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            jkm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(mParam1);
                        kadm.setTopic("Activities at home");
                        kadm.setSubject("English "+ mParam2);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            mnb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(mParam1);
                        kadm.setTopic("Activities at home");
                        kadm.setSubject("English "+ mParam2);
                        kadm.setTopic_rating(item);
                        makeRating(kadm,ada,pb,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            mlb.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        pb.setVisibility(View.VISIBLE);
                        kadm.setStudent_name(mParam1);
                        kadm.setTopic("Ocupations");
                        kadm.setSubject("English "+ mParam2);
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