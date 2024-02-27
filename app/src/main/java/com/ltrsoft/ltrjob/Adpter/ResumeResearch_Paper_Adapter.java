package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Research_Paper;

import java.util.ArrayList;
import java.util.List;

public class ResumeResearch_Paper_Adapter extends RecyclerView.Adapter<ResumeResearch_Paper_Adapter.Research_paperViewHolder> {
    private Context context;
    private List<Research_Paper> research_paper;

    public ResumeResearch_Paper_Adapter(Context context, ArrayList<Research_Paper> researchPaper) {
        this.context = context;
        this.research_paper=researchPaper;
    }

    @NonNull
    @Override
    public ResumeResearch_Paper_Adapter.Research_paperViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.research_paper_layout, parent, false);
        return new Research_paperViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeResearch_Paper_Adapter.Research_paperViewHolder holder, int position) {
        Research_Paper researchPaper = research_paper.get(position);
        holder.research_citation.setText(researchPaper.getResearch_citation());
        holder.research_topic_name.setText(researchPaper.getResearch_topic_name());
    }

    @Override
    public int getItemCount() {
        return research_paper.size();
    }

    public static class Research_paperViewHolder extends RecyclerView.ViewHolder {

        TextView research_citation,research_topic_name;
        public Research_paperViewHolder(@NonNull View itemView) {
            super(itemView);
            research_topic_name=itemView.findViewById(R.id.research_topic_name);
            research_citation = itemView.findViewById(R.id.research_citation);
        }

    }
}
