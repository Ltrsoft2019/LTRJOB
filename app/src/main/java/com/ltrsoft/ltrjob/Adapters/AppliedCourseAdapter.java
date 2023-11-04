package com.ltrsoft.ltrjob.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.Classes.Course_Class;
import com.ltrsoft.ltrjob.Classes.User_Course_Class;
import com.ltrsoft.ltrjob.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AppliedCourseAdapter extends RecyclerView.Adapter<AppliedCourseAdapter.ViewHolder> {

    ArrayList <User_Course_Class>list_for_applied_course=new ArrayList<>();

    public AppliedCourseAdapter(ArrayList<User_Course_Class> list_for_applied_course) {
        this.list_for_applied_course = list_for_applied_course;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.applied_course_recyclr_layout,parent,false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User_Course_Class course_class = list_for_applied_course.get(position);

        holder.course_name.setText(course_class.getCourse_name());
        System.out.println("coursename= "+course_class.getCourse_name());
        holder.course_desc.setText(course_class.getCourse_description());
        holder.course_duration.setText(course_class.getCourse_duration());

//        holder.course_name.setText("ffa");
//        holder.course_desc.setText("course_class.getCourse_description()");
//        holder.course_desc.setText("course data");
//        holder.course_duration.setText("hii");
        String imgurl ="https://institute.ltr-soft.com/company_details/"+course_class.getCourse_image();
        Picasso.get().load(imgurl).into(holder.course_img);

    }
    @Override
    public int getItemCount() {
        return list_for_applied_course.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView course_img;
        public TextView course_name,course_desc,course_duration;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            course_img = itemView.findViewById(R.id.course_img);
            course_name = itemView.findViewById(R.id.course_name);
            course_desc = itemView.findViewById(R.id.course_description);
            course_duration = itemView.findViewById(R.id.course_duration);
        }
    }
}
