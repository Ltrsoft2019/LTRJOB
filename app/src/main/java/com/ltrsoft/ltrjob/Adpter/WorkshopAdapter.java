package com.ltrsoft.ltrjob.Adpter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.ltrsoft.ltrjob.R;
import com.ltrsoft.ltrjob.pojoclass.Workshop; // Make sure to import the correct class

import java.util.List;

public class WorkshopAdapter extends RecyclerView.Adapter<WorkshopAdapter.ViewHolder> {

    private List<Workshop> workshopList;

    public WorkshopAdapter(List<Workshop> workshopList) {
        this.workshopList = workshopList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.workshop_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Workshop model = workshopList.get(position);
        holder.t1.setText(model.getWorkshop_name());
        holder.t2.setText(model.getWorkshop_venue());
        holder.t3.setText(model.getWorkshop_date());
        holder.t4.setText(model.getWorkshop_level());
    }

    @Override
    public int getItemCount() {
        return workshopList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        CardView cardView;
        TextView t1, t2, t3, t4;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.workshop_title); // Change the IDs accordingly
            t2 = itemView.findViewById(R.id.workshop_description);
            t3 = itemView.findViewById(R.id.workshop_date);
            t4 = itemView.findViewById(R.id.workshop_level_name);
            cardView = itemView.findViewById(R.id.card_workshop); // Change the ID accordingly
        }
    }
}
