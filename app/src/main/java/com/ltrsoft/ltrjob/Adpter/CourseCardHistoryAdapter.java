package com.ltrsoft.ltrjob.Adpter;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.fragments.CourcehistoryFragment;
import com.ltrsoft.ltrjob.fragments.CourseDetailFragment;
import com.ltrsoft.ltrjob.pojoclass.Course_Class;

import java.util.ArrayList;

public class CourseCardHistoryAdapter extends RecyclerView.Adapter<CourseCardHistoryAdapter.ViewHolder> {

    private ArrayList<Course_Class> list;

    public CourseCardHistoryAdapter(ArrayList<Course_Class> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.corcehistoryadpter, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course_Class model = list.get(position);
        holder.courseName.setText(model.getCourse_name());
        holder.courseDuration.setText(model.getCourse_duration());
        holder.courseType.setText(model.getCreated_at());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                CourcehistoryFragment cd = new CourcehistoryFragment();
                Bundle args = new Bundle();
                args.putString("course_id", model.course_id);
                cd.setArguments(args);

                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, cd)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView courseType, courseDuration, courseName,a;
        ImageView imageView;
        LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            a=itemView.findViewById(R.id.duration);
            imageView = itemView.findViewById(R.id.image);
            courseName = itemView.findViewById(R.id.coursename);
            courseDuration = itemView.findViewById(R.id.duration);
            courseType = itemView.findViewById(R.id.coursetype);
            layout = itemView.findViewById(R.id.layout_CardView);
        }
    }
}
