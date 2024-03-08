package com.ltrsoft.ltrjob.Adpter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;

import com.ltrsoft.ltrjob.fragments.AwardUpdate;
import com.ltrsoft.ltrjob.fragments.ReasearchUpdate;
import com.ltrsoft.ltrjob.pojoclass.Research_Paper;

import java.util.List;

public class ResearchPaperAdapter extends RecyclerView.Adapter<ResearchPaperAdapter.ViewHolder> {

    private List<Research_Paper> researchPaperList;

    public ResearchPaperAdapter(List<Research_Paper> researchPaperList) {
        this.researchPaperList = researchPaperList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.research_paper_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Research_Paper model = researchPaperList.get(position);
        holder.t1.setText(model.getResearch_topic_name());
        holder.t2.setText(model.getResearch_author_1());
        holder.t3.setText(model.getResearch_paper_published_in_journal());
        holder.t4.setText(model.getResearch_citation());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReasearchUpdate awardUpdate=new ReasearchUpdate();
                AppCompatActivity activity=(AppCompatActivity)v.getContext();


                Bundle args =
                        new Bundle();
                String id = String.valueOf(model.getResearch_paper_id());
                Toast.makeText(activity, "id"+id, Toast.LENGTH_SHORT).show();
                args.putString("course_id", id);

                awardUpdate.setArguments(args);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container,awardUpdate).addToBackStack(null).commit();


            }
        });

    }

    @Override
    public int getItemCount() {
        return researchPaperList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView t1, t2, t3, t4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.paper_title);
            t2 = itemView.findViewById(R.id.paper_author);
            t3 = itemView.findViewById(R.id.paper_publish_date);
            t4 = itemView.findViewById(R.id.paper_journal_name);
            cardView = itemView.findViewById(R.id.card_paper);
        }
    }
}