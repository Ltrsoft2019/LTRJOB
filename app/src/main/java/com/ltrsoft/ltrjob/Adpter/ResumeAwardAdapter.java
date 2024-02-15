package com.ltrsoft.ltrjob.Adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Award;

import java.util.ArrayList;

public class ResumeAwardAdapter extends RecyclerView.Adapter<ResumeAwardAdapter.AwardViewHolder> {

    private Context context;
    private ArrayList<Award> awards;

    public ResumeAwardAdapter(Context context, ArrayList<Award> Award) {
        this.context = context;
        this.awards = Award;
    }
    @NonNull
    @Override
    public AwardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_award, parent, false);
        return new AwardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AwardViewHolder holder, int position) {
        Award award = awards.get(position);
        holder.text_award_title.setText(award.getAward_name());
    }
    @Override
    public int getItemCount() {
        return awards.size();
    }

    public void setAwards(ArrayList<Award> awards) {
        this.awards=awards;
    }

    static class AwardViewHolder extends RecyclerView.ViewHolder {
        TextView text_award_title;
        public AwardViewHolder(@NonNull View itemView) {
            super(itemView);
            text_award_title = itemView.findViewById(R.id.text_award_title);
        }
    }


}
