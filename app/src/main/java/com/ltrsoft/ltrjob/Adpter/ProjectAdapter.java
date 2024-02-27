package com.ltrsoft.ltrjob.Adpter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.fragments.CerificationUpdate;
import com.ltrsoft.ltrjob.fragments.ProjectUpdate;
import com.ltrsoft.ltrjob.pojoclass.Project; // Assuming your Project class is named Project
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProjectAdapter extends RecyclerView.Adapter<ProjectAdapter.ViewHolder> {

    private List<Project> projectList;

    public ProjectAdapter(List<Project> projectList) {
        this.projectList = projectList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Project model = projectList.get(position);
        holder.t1.setText(model.getProjectName());
        holder.t2.setText(model.getProjectDescription());
        holder.t3.setText(model.getStartDate());
        holder.t4.setText(model.getEndDate());
holder.cardView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        AppCompatActivity activity=(AppCompatActivity)v.getContext();

        ProjectUpdate update = new ProjectUpdate();

        Bundle args = new Bundle();
        String id = String.valueOf(model.getProject_id());
        args.putString("project_id", id);

        update.setArguments(args);
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, update).addToBackStack(null).commit();


    }
});


    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView t1, t2, t3, t4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.project_title);
            t2 = itemView.findViewById(R.id.project_description);
            t3 = itemView.findViewById(R.id.start_date);
            t4 = itemView.findViewById(R.id.end_date);
            cardView = itemView.findViewById(R.id.card2);
        }
    }
}
