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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Pe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Pe extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String s_name;
    private String grade;

    public Pe() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Pe.
     */
    // TODO: Rename and change types and number of parameters
    public static Pe newInstance(String param1, String param2) {
        Pe fragment = new Pe();
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
        return inflater.inflate(R.layout.fragment_pe, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        try {
            ProgressBar pb=(ProgressBar) getView().findViewById(R.id.PB_pe);
            Spinner j =getView().findViewById(R.id.Gamesandsports_spnr);
            Spinner k =getView().findViewById(R.id.Swimming_sp);
            Spinner jnm =getView().findViewById(R.id.GymnasticsSpinner);
            Spinner jkm =getView().findViewById(R.id.hafSpinner);
            Spinner mnb =getView().findViewById(R.id.firstaidSpinner);
            Spinner mlb =getView().findViewById(R.id.Outdoorsp);
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
                        kadm.setStudent_name(s_name);
                        kadm.setTopic("Games and sports");
                        kadm.setSubject("PE "+ grade);
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
                        kadm.setStudent_name(s_name);
                        kadm.setTopic("Swimming");
                        kadm.setSubject("PE "+ grade);
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
                        kadm.setStudent_name(s_name);
                        kadm.setTopic("Gymnastics");
                        kadm.setSubject("PE "+ grade);
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
                        kadm.setStudent_name(s_name);
                        kadm.setTopic("Health and fitness");
                        kadm.setSubject("PE "+ grade);
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
                        kadm.setStudent_name(s_name);
                        kadm.setTopic("First aid in sports");
                        kadm.setSubject("PE "+ grade);
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
                        kadm.setStudent_name(s_name);
                        kadm.setTopic("Outdoor activities");
                        kadm.setSubject("PE "+ grade);
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