package com.ltrsoft.ltrjob.Adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
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
        holder.t5.setText(model.getTechnology());

        // You can add more fields as needed
    }

    @Override
    public int getItemCount() {
        return projectList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView projectImageView;

        TextView t1, t2, t3, t4, t5;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.project_title);
            t2 = itemView.findViewById(R.id.project_description);
            t3 = itemView.findViewById(R.id.start_date);
            t4 = itemView.findViewById(R.id.end_date);
            t5 = itemView.findViewById(R.id.card2);
        }
    }
}
