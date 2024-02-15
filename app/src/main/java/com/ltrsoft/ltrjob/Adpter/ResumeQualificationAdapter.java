package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Qualification;

import java.util.ArrayList;

public class ResumeQualificationAdapter extends RecyclerView.Adapter<ResumeQualificationAdapter.QualificationViewHolder> {


    private Context context;
    private ArrayList<Qualification> qualification;

    public ResumeQualificationAdapter(Context context, ArrayList<Qualification> qualification) {
        this.context = context;
        this.qualification = qualification;
    }
    @NonNull
    @Override
    public QualificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_qualification, parent, false);
        return new QualificationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QualificationViewHolder holder, int position) {
        Qualification qualification1 = qualification.get(position);
//        holder.qualification_level_name.setText(qualification1);
//        holder.qualification_type.setText(qualification1.getQualificationType());
//        holder.qualification_university.setText(qualification1.getQualificationUniversity());
//        holder.qualification_duration.setText(qualification1.getQualificationDuration());
    }

    @Override
    public int getItemCount() {
        return qualification.size();
    }

    static class QualificationViewHolder extends RecyclerView.ViewHolder {
        TextView qualification_level_name, qualification_type, qualification_university, qualification_duration;
        public QualificationViewHolder(@NonNull View itemView) {
            super(itemView);
//            qualification_level_name = itemView.findViewById(R.id.qualification_level_name);
//            qualification_type = itemView.findViewById(R.id.qualification_type);
//            qualification_university = itemView.findViewById(R.id.qualification_university);
//            qualification_duration = itemView.findViewById(R.id.qualification_duration);
        } 
    }
}
