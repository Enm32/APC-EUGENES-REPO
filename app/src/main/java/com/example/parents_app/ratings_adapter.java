package com.example.parents_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parents_app.models.ratings;

import java.util.List;

public class ratings_adapter extends RecyclerView.Adapter<ratings_adapter.ViewHolder> {


    private List<ratings> ratess;
    private Context context;
    public ratings_adapter() {
    }

    public ratings_adapter(Context gn,List<ratings> gh) {
        this.ratess=gh;
        this.context=gn;
    }

    public void setRatess(List<ratings> ratess) {
        this.ratess = ratess;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rates_act, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ratings rt=ratess.get(position);


       holder.thj.setText(rt.getTopic());
       holder.jkl.setText(rt.getRating());

    }

    @Override
    public int getItemCount() {
        return ratess.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {

        private TextView thj;
        private TextView jkl;
        public ViewHolder(View view) {
            super(view);

            thj=(TextView) view.findViewById(R.id.idTVCourseName);
            jkl=(TextView) view.findViewById(R.id.idTVCourseTracks);
        }


    }
}
