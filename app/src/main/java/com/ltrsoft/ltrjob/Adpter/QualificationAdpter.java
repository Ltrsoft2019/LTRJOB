package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.ltrsoft.ltrjob.R;
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
        holder.cnme.setText(model.getQualification_school_college());
        holder.year.setText(model.getQualification_passing_year());
        holder.cgpa.setText(model.getQualification_percentage_cgpa());
    }

    @Override
    public int getItemCount() {
        return qualificationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cnme, cgpa, year;
        CardView qualificationCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cnme = itemView.findViewById(R.id.name);
            cgpa = itemView.findViewById(R.id.cgp);
            year = itemView.findViewById(R.id.year);
        }
    }
}
