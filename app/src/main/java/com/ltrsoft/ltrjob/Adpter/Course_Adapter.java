package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;

import com.ltrsoft.ltrjob.pojoclass.Course_Class;
import com.ltrsoft.ltrjob.pojoclass.Event_class;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Course_Adapter extends RecyclerView.Adapter<Course_Adapter.ViewHolder> {
    private Context context;
    private List<Course_Class> imageList;


    public Course_Adapter(List<Course_Class> imageList) {
        this.context = context;
        this.imageList = imageList;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.course_card,parent,false);
        return new Course_Adapter.ViewHolder(v);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Course_Class model=imageList.get(position);

        holder.java.setText(model.getCourse_description());
        holder.day.setText(model.getCourse_duration());


    }

    @Override
    public int getItemCount() {
        return imageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView javaimg;
        TextView course,java,day;
        CardView course_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            javaimg=itemView.findViewById(R.id.javaimg);
            course = itemView.findViewById(R.id.course);
            java = itemView.findViewById(R.id.java);
            day = itemView.findViewById(R.id.day);
            course_card = itemView.findViewById(R.id.course_card);


        }
    }

}
