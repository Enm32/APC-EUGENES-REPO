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

import com.example.progresscheckerforcbc.CryptoManager;
import com.example.progresscheckerforcbc.R;
import com.example.progresscheckerforcbc.model.add_rating_model;
import com.example.progresscheckerforcbc.model.rating_response;
import com.example.progresscheckerforcbc.pp1_material.language_act_pp1;
import com.example.progresscheckerforcbc.retrofit.add_rating_api;
import com.example.progresscheckerforcbc.retrofit.retrofit_service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link languaeActpp2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class languaeActpp2 extends Fragment {

    private String mParam1;


    public languaeActpp2() {
        // Required empty public constructor
    }


    public static languaeActpp2 newInstance(String param1) {
        languaeActpp2 fragment = new languaeActpp2();
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
        View rrh=  inflater.inflate(R.layout.fragment_lapp2, container, false);
        readBundle(getArguments());
        return rrh;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        try {
            ProgressBar ln =(ProgressBar) getView().findViewById(R.id.idLoadingPBlapp2);
            Spinner la1 =getView().findViewById(R.id.laspp2_Spinner);
            Spinner la2 =getView().findViewById(R.id.Readingpp2spinner);
            Spinner la3 =getView().findViewById(R.id.Writingpp2Spinner);

            CryptoManager mnjk=new CryptoManager(getContext());
            String tok=  "Bearer " + mnjk.decrypt_m(mnjk.getKey());

            retrofit_service rs=new retrofit_service();
            add_rating_api ada=rs.getRetrofit().create(add_rating_api.class);
            add_rating_model lnn =new add_rating_model();

            la1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        ln.setVisibility(View.VISIBLE);
                        lnn.setStudent_name(mParam1);
                        lnn.setTopic("Listening and Speaking");
                        lnn.setSubject("Language Activities pp2");
                        lnn.setTopic_rating(item);
                        makeRating(lnn,ada, ln,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            la2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        ln.setVisibility(View.VISIBLE);
                        lnn.setStudent_name(mParam1);
                        lnn.setTopic("Reading");
                        lnn.setSubject("Language Activities pp2");
                        lnn.setTopic_rating(item);
                        makeRating(lnn,ada, ln,tok);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            la3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String item=(String) parent.getSelectedItem();
                    if(item!=parent.getItemAtPosition(0)){
                        ln.setVisibility(View.VISIBLE);
                        lnn.setStudent_name(mParam1);
                        lnn.setTopic("Writing");
                        lnn.setSubject("Language Activities pp2");
                        lnn.setTopic_rating(item);
                        makeRating(lnn,ada, ln,tok);
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