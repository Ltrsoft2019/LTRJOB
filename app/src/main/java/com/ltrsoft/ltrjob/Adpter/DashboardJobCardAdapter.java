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
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.fragments.Company_desc;
import com.ltrsoft.ltrjob.fragments.JobDetail;
import com.ltrsoft.ltrjob.fragments.Job_desc;
import com.ltrsoft.ltrjob.pojoclass.job;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

public class DashboardJobCardAdapter extends RecyclerView.Adapter<DashboardJobCardAdapter.ViewHolder> {
    ArrayList<job> list_das_job = new ArrayList<>();


    public DashboardJobCardAdapter(ArrayList<job> list_das_job) {
        this.list_das_job = list_das_job;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_verticle_recycler_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        job job_class = list_das_job.get(position);
        holder.dash_company_name.setText(job_class.getCompany_name());
        holder.dash_job_desc.setText(job_class.getJob_description());
        holder.dash_job_position.setText(job_class.getJob_position());

         String imgurl = "https://institute.ltr-soft.com/company_details/" + job_class.getImageurl();
         Picasso.get().load(imgurl).into(holder.dash_companylogo);


        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a bundle to pass data
                Bundle args = new Bundle();
                args.putString("company_name", job_class.getCompany_name());
                args.putString("company_email", job_class.getCompany_email());
                args.putString("job_description", job_class.getJob_description());
                args.putString("company_phone", job_class.getCompany_phone());
                args.putString("job_position", job_class.getJob_position());
                args.putString("company_hoaddress", job_class.getCompany_hoaddress());
                args.putString("job_category_name", job_class.getJob_category_name());
                args.putString("job_salary", job_class.getJob_salary());
                args.putString("company_id", job_class.getCompany_id());
                args.putString("company_logo", job_class.getImageurl());

                // Navigate to JobDetailFragment with the arguments
                AppCompatActivity activity1 = (AppCompatActivity) view.getContext();
                JobDetail jobDetailFragment = new JobDetail();
                jobDetailFragment.setArguments(args);
                activity1.getSupportFragmentManager().beginTransaction().add(R.id.container, jobDetailFragment).addToBackStack(null).commit();

                // Navigate to Job_desc fragment with the arguments
//                Job_desc job_desc = new Job_desc();
//                job_desc.setArguments(args);
//                activity1.getSupportFragmentManager().beginTransaction().add(R.id.frag, job_desc).addToBackStack(null).commit();


            }
        });

    }

    @Override
    public int getItemCount() {
        return list_das_job.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView dash_companylogo;
        public TextView dash_job_desc, dash_company_name, dash_job_position, dash_post_date;
        public ConstraintLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            dash_post_date = itemView.findViewById(R.id.dash_applied_date);
            dash_job_position = itemView.findViewById(R.id.dash_job_position);
            dash_company_name = itemView.findViewById(R.id.dash_company_name);
            dash_job_desc = itemView.findViewById(R.id.dash_job_description);
            dash_companylogo = itemView.findViewById(R.id.dash_companylog);
            layout = itemView.findViewById(R.id.dasboard_layout);
        }
    }
}
