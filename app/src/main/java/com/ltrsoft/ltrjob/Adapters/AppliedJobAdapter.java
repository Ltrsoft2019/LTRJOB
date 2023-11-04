package com.ltrsoft.ltrjob.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.Classes.User_JobHistory_Class;
import com.ltrsoft.ltrjob.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AppliedJobAdapter extends RecyclerView.Adapter<AppliedJobAdapter.ViewHolder> {
    ArrayList <User_JobHistory_Class> list = new ArrayList<>();

    public AppliedJobAdapter(ArrayList<User_JobHistory_Class> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public AppliedJobAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.applied_job_recycler_layout,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppliedJobAdapter.ViewHolder holder, int position) {
    User_JobHistory_Class history_class = list.get(position);
        holder.job_desc.setText(history_class.getJob_description());
        holder.job_position.setText(history_class.getJob_position());
        holder.company_name.setText(history_class.getCompany_name());
        holder.appied_date.setText("applied on = "+history_class.getCreated_at());
        String imgurl ="https://institute.ltr-soft.com/company_details/"+history_class.getCompany_logo();
        Picasso.get().load(imgurl).into(holder.companylogo);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView companylogo;
        public TextView job_desc,company_name,job_position,appied_date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            job_desc=itemView.findViewById(R.id.job_description);
            company_name= itemView.findViewById(R.id.company_name);
            job_position=itemView.findViewById(R.id.job_position);
            appied_date=itemView.findViewById(R.id.applied_date);
            companylogo=itemView.findViewById(R.id.companylog);
        }
    }
}
