package com.example.parents_app;

import static android.content.Context.MODE_PRIVATE;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parents_app.models.student_class;

import java.util.List;

public class studentListRVadapter extends RecyclerView.Adapter<studentListRVadapter.ViewHolder> {
    private final Context context;
    private List<student_class> students;

    public studentListRVadapter(Context tmn,List<student_class> su) {
        this.context=tmn;
        this.students=su;
    }
    public void setstudents(List<student_class> students) {
        this.students = students;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subjects_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.TV.setText(students.get(position).getStudentName());
        String str = holder.TV.getText().toString();

        holder.rv_ccv.setOnClickListener(v -> {
            SharedPreferences shred_preferences=context.getSharedPreferences("Important_info",MODE_PRIVATE);
            SharedPreferences.Editor editor = shred_preferences.edit();
            editor.putString("Grade",students.get(position).getStudent_grade());
            editor.putString("STUDENT_NAME",students.get(position).getStudentName());
            editor.apply();
            Intent newInt = new Intent(context, homeActivity.class);


            Activity activity = (Activity) context;
            activity.startActivity(newInt);
            activity.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);;
            // context.startActivity(newInt);

        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
        private CardView rv_ccv;
        private TextView TV;

        public ViewHolder(View view) {
            super(view);

            TV =  view.findViewById(R.id.card_text_1);
            rv_ccv =  view.findViewById(R.id.card_1);
        }


    }



}
