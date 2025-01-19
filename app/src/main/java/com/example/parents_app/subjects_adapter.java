package com.example.parents_app;






import static com.google.android.material.internal.ContextUtils.getActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class subjects_adapter extends RecyclerView.Adapter<subjects_adapter.ViewHolder> {
    private final Context context;
    private List<String> subs;

    public subjects_adapter(Context tmn,List<String> su) {
this.context=tmn;
this.subs=su;
    }
    public void setSubs(List<String> subs) {
        this.subs = subs;
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
        holder.thj.setText(subs.get(position));
        String str = holder.thj.getText().toString();

       holder.rv_ccv.setOnClickListener(v -> {
           Intent newInt = new Intent(context, ratingsActivity.class);
          newInt.putExtra("student_name",str);
           Activity activity = (Activity) context;
           activity.startActivity(newInt);
           activity.overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);;
        // context.startActivity(newInt);

       });
    }



    @Override
    public int getItemCount() {
        return subs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder  {
    private CardView rv_ccv;
    private TextView thj;

    public ViewHolder(View view) {
        super(view);

        thj =  view.findViewById(R.id.card_text_1);
        rv_ccv =  view.findViewById(R.id.card_1);
    }


}



}
