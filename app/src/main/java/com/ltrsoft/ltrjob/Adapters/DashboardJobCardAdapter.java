package com.ltrsoft.ltrjob.Adapters;

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

import com.ltrsoft.ltrjob.Classes.Dashboard_job_Class;
import com.ltrsoft.ltrjob.CompanyJobFragment.JobCardDisplayFragment;
import com.ltrsoft.ltrjob.CompanyJobFragment.JobDeatilFragment;
import com.ltrsoft.ltrjob.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DashboardJobCardAdapter extends RecyclerView.Adapter<DashboardJobCardAdapter.ViewHolder> {
    ArrayList <Dashboard_job_Class> list_das_job = new ArrayList<>();

    public DashboardJobCardAdapter(ArrayList<Dashboard_job_Class> list_das_job) {
        this.list_das_job = list_das_job;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_verticle_recycler_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Dashboard_job_Class job_class = list_das_job.get(position);
        holder.dash_company_name.setText(job_class.getCompany_name());
        holder.dash_job_desc.setText(job_class.getJob_description());
        holder.dash_job_position.setText(job_class.getJob_position());
       // holder.dash_post_date.setText(job_class.getJob_start_date_to_apply());
        String imgurl ="https://institute.ltr-soft.com/company_details/"+job_class.getCompany_logo();
        Picasso.get().load(imgurl).into(holder.dash_companylogo);
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                Bundle bundle = new Bundle();

                bundle.putString("job_category_id","Full Time");
                bundle.putString("job_position",job_class.getJob_position());
                bundle.putString("company_name",job_class.getCompany_name());
                bundle.putString("company_logo",job_class.getCompany_logo());
                bundle.putString("job_description",job_class.getJob_description());
                bundle.putString("job_start_date_to_apply",job_class.getJob_start_date_to_apply());
                bundle.putString("job_criteria_to_apply",job_class.getJob_criteria_to_apply());
                bundle.putString("job_end_date_to_apply",job_class.getJob_end_date_to_apply());
                bundle.putString("job_website_to_apply",job_class.getJob_website_to_apply());
                bundle.putString("company_phone",job_class.getCompany_phone());
                bundle.putString("company_domain",job_class.getCompany_domain());
                bundle.putString("company_hoaddress",job_class.getCompany_hoaddress());
                bundle.putString("company_hostate",job_class.getCompany_hostate());
                bundle.putString("company_hocountry",job_class.getCompany_hocountry());
                bundle.putString("state_name",job_class.getCompany_hostate());
                bundle.putString("city_name",job_class.getCompany_hocity());
                JobDeatilFragment jobDeatilFragment = new JobDeatilFragment();
                jobDeatilFragment.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,jobDeatilFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
    @Override
    public int getItemCount() {
        return list_das_job.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView dash_companylogo;
        public TextView dash_job_desc,dash_company_name,dash_job_position,dash_post_date;
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
