package com.example.progresscheckerforcbc.pp2_material;

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
import com.example.progresscheckerforcbc.all_grade_rates_act;
import com.example.progresscheckerforcbc.model.students;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class rv_adapter extends RecyclerView.Adapter<rv_adapter.viewholder>{
    private Context context;
    private String grd;
    public rv_adapter(Context ncontext, String grd){
        context=ncontext;
        this.grd=grd;
    };



    private List<students> sn=new ArrayList<>();

    public void setSn(List<students> snm) {
        sn = snm;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.students_list,parent,false);
        viewholder holder=new viewholder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
      try {

          holder.txt.setText(sn.get(position).getStudent_name());
          String str = holder.txt.getText().toString();

          holder.ccv.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {

                  if(Objects.equals(grd, "pp2")){
                       Intent ijl = new Intent(context, rates.class);
                      ijl.putExtra("s_name", str);
                      context.startActivity(ijl);
                  }
                  Intent i = new Intent(context, all_grade_rates_act.class);
                  i.putExtra("s_name", str);
                  i.putExtra("s_grade",grd);
                  context.startActivity(i);
              }
          });
      }catch (Exception e){
          Toast.makeText(context.getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
          Logger.getLogger(rv_adapter.class.getName()).log(Level.SEVERE,"error occured",e);
      }

    }



    @Override
    public int getItemCount() {
        return sn.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
     private CardView ccv;
        private TextView txt;
       public viewholder(@NonNull View itemView) {
           super(itemView);
           txt=itemView.findViewById(R.id.stu_names);
           ccv=itemView.findViewById(R.id.rvcdv);
       }
   }
}
