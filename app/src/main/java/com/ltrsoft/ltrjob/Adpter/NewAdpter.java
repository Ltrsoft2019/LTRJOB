package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.fragments.JobDetail;
import com.ltrsoft.ltrjob.fragments.NewsDetail;
import com.ltrsoft.ltrjob.pojoclass.NewsClass;
import com.ltrsoft.ltrjob.pojoclass.job;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class NewAdpter extends RecyclerView.Adapter<NewAdpter.ViewHolder> {

    private ArrayList<NewsClass> listDasJob;

    public NewAdpter(ArrayList<NewsClass> listDasJob) {
        this.listDasJob = listDasJob;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsClass jobClass = listDasJob.get(position);
        holder.dashName.setText(jobClass.getNews_title());
        holder.dashJobDesc.setText(jobClass.getNews_description());
//        holder.dashJobPosition.setText(jobClass.getNews_resource());

        String imgUrl = "https://institute.ltr-soft.com/company_details/" + jobClass.getNews_photo_path();
        Picasso.get().load(imgUrl).into(holder.news_logo);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Bundle args = new Bundle();
                args.putString("company_name", jobClass.getNews_title());
                args.putString("company_email", jobClass.getNews_description());
                args.putString("job_description", jobClass.getNews_date());
                args.putString("company_phone", jobClass.getNews_resource());
                args.putString("job_position", jobClass.getNews_photo_path());


                NewsDetail jobDetailFragment = new NewsDetail();
                jobDetailFragment.setArguments(args);

                AppCompatActivity activity = (AppCompatActivity) context;
                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container1, jobDetailFragment)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listDasJob.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView news_logo;
        public TextView dashName, applied_date,dashJobDesc;

        public RelativeLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            news_logo = itemView.findViewById(R.id.image1);
            dashJobDesc=itemView.findViewById(R.id.newsposition);
            dashName=itemView.findViewById(R.id.news_description);
            applied_date=itemView.findViewById(R.id.news_applied_date);

            layout=itemView.findViewById(R.id.dasboard_layout);
        }
    }
}