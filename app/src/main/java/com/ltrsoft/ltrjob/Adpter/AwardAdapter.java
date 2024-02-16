package com.ltrsoft.ltrjob.Adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Award;

import java.util.List;

public class AwardAdapter extends RecyclerView.Adapter<AwardAdapter.ViewHolder> {

    private List<Award> awardList;

    public AwardAdapter(List<Award> awardList) {
        this.awardList = awardList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.award_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Award model = awardList.get(position);
        holder.t1.setText(model.getName());
        holder.t2.setText(model.getAwardvanue());
        holder.t3.setText(model.getReciveddate());
        holder.t4.setText(model.getAwardcategeryname());
    }

    @Override
    public int getItemCount() {
        return awardList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView t1, t2, t3,t4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.award_title);
            t2 = itemView.findViewById(R.id.award_description);
            t3 = itemView.findViewById(R.id.award_date);
            t4 = itemView.findViewById(R.id.award_level_name);
            cardView=itemView.findViewById(R.id.card_award);


        }
    }
}
