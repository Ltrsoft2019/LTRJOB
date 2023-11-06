package com.ltrsoft.ltrjob.Adapters;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.CoursesFragment.CourseDetailFragment;

import com.ltrsoft.ltrjob.Classes.Course_Class;
import com.ltrsoft.ltrjob.R;

import java.util.ArrayList;

public class CourseCardAdapter extends RecyclerView.Adapter <CourseCardAdapter.ViewHolderr>{

    ArrayList<Course_Class>list=new ArrayList<>();
    public CourseCardAdapter(ArrayList<Course_Class>list){this.list=list;}
    @NonNull
    @Override
    public ViewHolderr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.courses_cardview,parent,false);
        return new CourseCardAdapter.ViewHolderr(view);
     }
    @Override
    public void onBindViewHolder(@NonNull ViewHolderr holder, int position) {
        Course_Class model=list.get(position);
        holder.course_name.setText(model.getCourse_name());
        holder.course_type.setText("Full course");
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
        RelativeLayout layout;
        public ViewHolderr(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            course_name=itemView.findViewById(R.id.coursename);
            course_duration=itemView.findViewById(R.id.duration);
            course_type=itemView.findViewById(R.id.coursetype);
            layout=itemView.findViewById(R.id.Relativelayout);
        }

    }

}
