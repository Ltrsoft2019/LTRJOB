package com.ltrsoft.ltrjob.Adpter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.ltrsoft.ltrjob.R;

import com.ltrsoft.ltrjob.pojoclass.job;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class JobHistoryAdapter extends RecyclerView.Adapter<JobHistoryAdapter.ViewHolder> {
    private ArrayList<job> jobHistoryList;

    public JobHistoryAdapter(ArrayList<job> jobHistoryList) {
        this.jobHistoryList = jobHistoryList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.job_history_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        job job_class = jobHistoryList.get(position);
        holder.dash_job_desc.setText(job_class.getCompany_name());
        holder.dash_company_name.setText(job_class.getJob_description());
        holder.dash_job_position.setText(job_class.getJob_position());

        String imgurl = "https://institute.ltr-soft.com/company_details/" + job_class.getImageurl();
        Picasso.get().load(imgurl).into(holder.companyLogoImageView);



    }

    @Override
    public int getItemCount() {
        return jobHistoryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView companyLogoImageView;
        public TextView dash_job_desc, dash_company_name, dash_job_position, dash_post_date;
        public ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dash_post_date = itemView.findViewById(R.id.dash_applied_date1);
            dash_job_position = itemView.findViewById(R.id.dash_job_position1);
            dash_company_name = itemView.findViewById(R.id.dash_company_name1);
            dash_job_desc = itemView.findViewById(R.id.dash_job_description1);
            companyLogoImageView = itemView.findViewById(R.id.dash_companylog1);
            layout = itemView.findViewById(R.id.dasboard_layout);
        }
    }
}
