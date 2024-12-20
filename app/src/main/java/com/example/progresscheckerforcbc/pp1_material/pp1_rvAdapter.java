package com.example.progresscheckerforcbc.pp1_material;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.progresscheckerforcbc.R;
import com.example.progresscheckerforcbc.model.students;
import com.example.progresscheckerforcbc.pp2_material.rates;
import com.example.progresscheckerforcbc.pp2_material.rv_adapter;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class pp1_rvAdapter  extends RecyclerView.Adapter<pp1_rvAdapter.viewholder>{

    private Context jcontext;
    public pp1_rvAdapter(Context ncontext){
        jcontext=ncontext;
    };
    private List<students> sn=new ArrayList<>();

    public void setSn(List<students> snm) {
        sn = snm;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.students_list,parent,false);
        viewholder v_holder=new viewholder(view);
        return v_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder v_holder, int position) {
        try {

            v_holder.n_txt.setText(sn.get(position).getStudent_name());
            String pp1_str = v_holder.n_txt.getText().toString();

            v_holder.n_ccv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(jcontext, pp1_rate.class);
                    i.putExtra("pp1s_name", pp1_str);
                    jcontext.startActivity(i);
                }
            });
        }catch (Exception e){
            Toast.makeText(jcontext.getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
            Logger.getLogger(rv_adapter.class.getName()).log(Level.SEVERE,"error occured",e);
        }
    }

    @Override
    public int getItemCount() {
        return sn.size();
    }


    public class viewholder extends RecyclerView.ViewHolder{
        private CardView n_ccv;
        private TextView n_txt;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            n_txt=itemView.findViewById(R.id.stu_names);
            n_ccv=itemView.findViewById(R.id.rvcdv);
        }
    }
}
