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
import com.ltrsoft.ltrjob.fragments.ReasearchUpdate;
import com.ltrsoft.ltrjob.pojoclass.Research_Paper;

import java.util.List;

public class ResumeResearch_Paper_Adapter extends RecyclerView.Adapter<ResumeResearch_Paper_Adapter.ViewHolder> {

    private List<Research_Paper> researchPaperList;

    public ResumeResearch_Paper_Adapter(List<Research_Paper> researchPaperList) {
        this.researchPaperList = researchPaperList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.research_paper_item_layout1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Research_Paper model = researchPaperList.get(position);
        holder.t1.setText(model.getResearch_topic_name());

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
            t1 = itemView.findViewById(R.id.paper);

        }
    }
}
