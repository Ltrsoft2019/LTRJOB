package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.fragments.QualificationUpdate;
import com.ltrsoft.ltrjob.fragments.UpdateTechnicalSkill;
import com.ltrsoft.ltrjob.pojoclass.Qualification;
import java.util.List;

public class QualificationAdpter extends RecyclerView.Adapter<QualificationAdpter.ViewHolder> {
    private Context context;
    private List<Qualification> qualificationList;

    public QualificationAdpter(List<Qualification> qualificationList) {
        this.qualificationList = qualificationList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.qualification_card, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Qualification model = qualificationList.get(position);
        holder.collegenme.setText(model.getQualification_school_college());
        holder.passingyear.setText(model.getQualification_passing_year());
        holder.percentage.setText(model.getQualification_percentage_cgpa());
     holder.   qualificationCard.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

             AppCompatActivity activity=(AppCompatActivity)v.getContext();

             QualificationUpdate updateTechnicalSkill = new QualificationUpdate();

             Bundle args = new Bundle();
             String id = String.valueOf(model.getQualification_id());
             Toast.makeText(activity, "id"+id, Toast.LENGTH_SHORT).show();
             args.putString("course_id", id);

             updateTechnicalSkill.setArguments(args);
             activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,updateTechnicalSkill).addToBackStack(null).commit();


         }
     });
    }

    @Override
    public int getItemCount() {
        return qualificationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView collegenme, percentage, passingyear;
        CardView qualificationCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            collegenme = itemView.findViewById(R.id.name);
            percentage = itemView.findViewById(R.id.cgp);
            passingyear = itemView.findViewById(R.id.year);
            qualificationCard=itemView.findViewById(R.id.card);
        }
    }
}
