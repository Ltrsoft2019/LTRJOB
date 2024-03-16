package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.daoclasses.Batch_Deo;
import com.ltrsoft.ltrjob.fragments.Batch_Detail;
import com.ltrsoft.ltrjob.fragments.CourseDetailFragment;
import com.ltrsoft.ltrjob.fragments.Course_Apply;
import com.ltrsoft.ltrjob.interfaces.UserCallBack;
import com.ltrsoft.ltrjob.pojoclass.Batch;

import java.util.ArrayList;

public class Batch_card_adapter extends RecyclerView.Adapter<Batch_card_adapter.ViewHolder> {

    ArrayList<Batch> list=new ArrayList<>();

    public Batch_card_adapter(ArrayList<Batch>list){
        this.list=list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.batch_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Batch_card_adapter.ViewHolder holder, int position) {
        Batch batch=list.get(position);
        System.out.println("List==="+batch.getBatch_id());
        holder.time.setText(batch.getBatch_time());
        holder.batch_name.setText(batch.getBatch_name());
        holder.start.setText(batch.getBatch_start_date());
        holder.end.setText(batch.getBatch_end_date());

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity=(AppCompatActivity)v.getContext();
                Course_Apply courseApply = new Course_Apply();
                Bundle args = new Bundle();
                String id = batch.getBatch_id();
                Toast.makeText(activity, "id"+id, Toast.LENGTH_SHORT).show();
                args.putString("batch_id", id);

                courseApply.setArguments(args);

                activity.getSupportFragmentManager().beginTransaction().replace(R.id.constraint,courseApply).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView time;
        private TextView batch_name,start,end;
        private LinearLayout layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            time = itemView.findViewById(R.id.time);
            batch_name = itemView.findViewById(R.id.batch_name);
            start = itemView.findViewById(R.id.start);
            end = itemView.findViewById(R.id.end);
            layout =itemView.findViewById(R.id.layout);
        }
    }

}
