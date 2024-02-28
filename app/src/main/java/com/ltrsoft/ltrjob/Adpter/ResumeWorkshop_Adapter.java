package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Workshop;

import java.util.List;

public class ResumeWorkshop_Adapter extends RecyclerView.Adapter<ResumeWorkshop_Adapter.WorkshopViewHolder> {
    private Context context;
    private List<Workshop> workshops ;

    public ResumeWorkshop_Adapter(Context context, List<Workshop> workshops) {
        this.context = context;
        this.workshops = workshops;
    }

    @NonNull
    @Override
    public WorkshopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.resume_workshop_item_layout, parent, false);
        return new WorkshopViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ResumeWorkshop_Adapter.WorkshopViewHolder holder, int position) {
        Workshop workshop= workshops.get(position);
        holder.workshop_name.setText(workshop.getWorkshop_name());
    }

    @Override
    public int getItemCount() {
        System.out.println("size= "+workshops.size());
        return workshops.size();
    }

    public static class WorkshopViewHolder extends RecyclerView.ViewHolder {

        TextView workshop_name;
        public WorkshopViewHolder(@NonNull View itemView) {
            super(itemView);
            workshop_name = itemView.findViewById(R.id.workshop_name);

        }
    }
}
