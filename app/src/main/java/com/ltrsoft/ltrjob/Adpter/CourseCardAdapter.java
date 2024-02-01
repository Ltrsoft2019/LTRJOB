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
import com.ltrsoft.ltrjob.fragments.CourseDetailFragment;
import com.ltrsoft.ltrjob.pojoclass.Course_Class;


import java.util.ArrayList;

public class CourseCardAdapter extends RecyclerView.Adapter <CourseCardAdapter.ViewHolderr>{

    ArrayList<Course_Class>list=new ArrayList<>();
    public CourseCardAdapter(ArrayList<Course_Class>list){this.list=list;}
    @NonNull
    @Override
    public ViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.courses_cardview,parent,false);
        return new ViewHolderr(view);
     }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderr holder, int position) {
        Course_Class model=list.get(position);
        holder.course_name.setText(model.getCourse_name());

        holder.course_type.setText(model.getCreated_at());
        holder.course_duration.setText(model.getCourse_duration());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AppCompatActivity activity=(AppCompatActivity)view.getContext();
                CourseDetailFragment cd=new CourseDetailFragment();
                Bundle args = new Bundle();
                args.putString("course_id", model.course_id);


                cd.setArguments(args);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,cd).addToBackStack(null).commit();

            }
        });

        // holder.imageView.setImageResource(model.getImage());
        //  holder.course_type.setText(model.getCourse_type());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolderr extends RecyclerView.ViewHolder{
        TextView course_type,course_duration,course_name;
        ImageView imageView;
        LinearLayout layout;
        public ViewHolderr(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            course_name=itemView.findViewById(R.id.coursename);
            course_duration=itemView.findViewById(R.id.duration);
            course_type=itemView.findViewById(R.id.coursetype);
            layout=itemView.findViewById(R.id.layout_CardView);
        }

    }

}
